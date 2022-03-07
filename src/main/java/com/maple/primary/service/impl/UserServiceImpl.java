package com.maple.primary.service.impl;

import com.maple.primary.dto.UserDTO;
import com.maple.primary.entity.UserDO;
import com.maple.primary.mapper.UserMapper;
import com.maple.primary.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
