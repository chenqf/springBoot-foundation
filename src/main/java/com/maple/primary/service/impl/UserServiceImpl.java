package com.maple.primary.service.impl;

import com.github.pagehelper.PageInfo;
import com.maple.primary.base.dto.PageDTO;
import com.maple.primary.base.utils.page.MyPageHelper;
import com.maple.primary.entity.User;
import com.maple.primary.mapper.UserMapper;
import com.maple.primary.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author qifeng.b.chen
 * @since 2022-03-09 16:51:01
 */
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource private UserMapper userMapper;

  /**
   * 通过搜索条件和分页信息查询数据
   *
   * @return 分页列表数据
   */
  @Override
  public PageInfo<User> queryPages(PageDTO pageDTO) {
    MyPageHelper.startPage(pageDTO);
    return PageInfo.of(this.userMapper.queryList(new User()));
  }

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  @Override
  public User queryById(Long id) {
    return this.userMapper.queryById(id);
  }

  /**
   * 新增数据
   *
   * @param user 实例对象
   * @return 实例对象
   */
  @Override
  public User insert(User user) {
    this.userMapper.insert(user);
    return user;
  }

  /**
   * 修改数据
   *
   * @param user 实例对象
   * @return 实例对象
   */
  @Override
  public User update(User user) {
    this.userMapper.update(user);
    return this.queryById(user.getId());
  }

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  @Override
  public boolean deleteById(Long id) {
    return this.userMapper.deleteById(id) > 0;
  }
}
