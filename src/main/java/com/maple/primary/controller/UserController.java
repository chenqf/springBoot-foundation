package com.maple.primary.controller;

import com.github.pagehelper.PageInfo;
import com.maple.primary.base.dto.PageDTO;
import com.maple.primary.entity.User;
import com.maple.primary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author qifeng.b.chen
 * @since 2022-03-09 16:40:08
 */
@RestController
@RequestMapping("user")
public class UserController {
  /** 服务对象 */
  @Resource private UserService userService;

  /**
   * 通过搜索条件和分页信息查询数据
   *
   * @return 分页列表数据
   */
  @GetMapping
  public PageInfo<User> queryPages(PageDTO pageDTO, User user) {
    System.out.println("--------------------");
    System.out.println(pageDTO);
    System.out.println(user);
    System.out.println("--------------------");
    return this.userService.queryPages(pageDTO);
  }

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("{id}")
  public User queryById(@PathVariable("id") Long id) {
    return this.userService.queryById(id);
  }

  /**
   * 新增数据
   *
   * @param user 实体
   * @return 新增结果
   */
  @PostMapping
  public ResponseEntity<User> add(User user) {
    return ResponseEntity.ok(this.userService.insert(user));
  }

  /**
   * 编辑数据
   *
   * @param user 实体
   * @return 编辑结果
   */
  @PutMapping
  public ResponseEntity<User> edit(User user) {
    return ResponseEntity.ok(this.userService.update(user));
  }

  /**
   * 删除数据
   *
   * @param id 主键
   * @return 删除是否成功
   */
  @DeleteMapping
  public ResponseEntity<Boolean> deleteById(Long id) {
    return ResponseEntity.ok(this.userService.deleteById(id));
  }
}
