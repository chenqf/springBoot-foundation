package com.maple.primary.service.impl;

import com.maple.primary.dto.UserDTO;
import com.maple.primary.entity.UserDO;
import com.maple.primary.mapper.UserMapper;
import com.maple.primary.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/27-18:35
 * @since 1.8
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired UserMapper userMapper;

  @Override
  public UserDTO getById(Long id) {
    UserDO userDO = this.userMapper.getById(id);
    UserDTO userDTO = new UserDTO();
    BeanUtils.copyProperties(userDO, userDTO);
    return userDTO;
  }

  @Override
  public UserDTO getByUsername(String username) {
    UserDO userDO = this.userMapper.getByUsername(username);
    UserDTO userDTO = new UserDTO();
    BeanUtils.copyProperties(userDO, userDTO);
    return userDTO;
  }

  @Override
  public Long insert(UserDTO userDTO) {
    String prevPassword = userDTO.getPassword();
    String random = String.valueOf(Math.random()).substring(2);
    String key = random + prevPassword;
    // 对 随机码和密码 进行md5加密
    String md5Password = DigestUtils.md5DigestAsHex(key.getBytes());
    UserDO userDO = new UserDO();
    BeanUtils.copyProperties(userDTO, userDO);
    userDO.setRandom(random);
    userDO.setPassword(md5Password);
    this.userMapper.insert(userDO);
    return userDO.getId();
  }

  @Override
  public void update(UserDTO userDTO) {
    UserDO userDO = new UserDO();
    BeanUtils.copyProperties(userDTO, userDO);
    this.userMapper.update(userDO);
  }

  @Override
  public void delete(Long id) {
    UserDO userDO = new UserDO();
    userDO.setId(id);
    userDO.setDeleted(true);
    this.userMapper.update(userDO);
  }

  @Override
  public UserDTO checkLogin(String username, String password) throws Exception {
    UserDO userDO = this.userMapper.getByUsername(username);
    if (null == userDO) {
      throw new Exception("用户名或密码错误");
    }
    String passwordInDB = userDO.getPassword();
    String random = userDO.getRandom();
    String key = random + password;
    // 对 随机码和密码 进行md5加密
    String md5Password = DigestUtils.md5DigestAsHex(key.getBytes());
    if (!md5Password.equals(passwordInDB)) {
      throw new Exception("用户名或密码错误");
    }

    UserDTO userDTO = new UserDTO();
    BeanUtils.copyProperties(userDO, userDTO);
    return userDTO;
  }

  @Override
  public void changePassword(Long id, String oldPassword, String password) throws Exception {
    UserDO userDO = this.userMapper.getById(id);
    String random = userDO.getRandom();
    String oldKey = random + oldPassword;
    String oldMd5Password = DigestUtils.md5DigestAsHex(oldKey.getBytes());
    if (!oldMd5Password.equals(userDO.getPassword())) {
      throw new Exception("原密码有误");
    }
    String newKey = random + password;
    String md5Password = DigestUtils.md5DigestAsHex(newKey.getBytes());
    userDO.setPassword(md5Password);
    this.userMapper.update(userDO);
  }
}
