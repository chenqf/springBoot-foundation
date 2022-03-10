package com.maple.primary.service;

import com.github.pagehelper.PageInfo;
import com.maple.primary.base.dto.PageDTO;
import com.maple.primary.entity.User;

/**
 * (User)表服务接口
 *
 * @author qifeng.b.chen
 * @since 2022-03-09 16:40:10
 */
public interface UserService {

  /**
   * 通过搜索条件和分页信息查询数据
   *
   * @param pageDTO 分页数据
   * @return 分页列表数据
   */
  PageInfo<User> queryPages(PageDTO pageDTO);

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  User queryById(Long id);

  /**
   * 新增数据
   *
   * @param user 实例对象
   * @return 实例对象
   */
  User insert(User user);

  /**
   * 修改数据
   *
   * @param user 实例对象
   * @return 实例对象
   */
  User update(User user);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  boolean deleteById(Long id);
}
