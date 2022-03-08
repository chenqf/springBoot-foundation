package com.maple.primary.controller;

import com.maple.primary.dto.UserDTO;
import com.maple.primary.entity.UserDO;
import com.maple.primary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/26-16:11
 * @since 1.8
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired private UserService userService;

  @GetMapping("/list")
  public List<UserDO> list() {
    return null;
  }

  @GetMapping("/insert")
  public UserDTO insert() {
    UserDTO userDTO = new UserDTO();
    userDTO.setUsername("chen");
    userDTO.setName("qifeng");
    userDTO.setPassword("123456");
    userDTO.setStatus(0);
    this.userService.insert(userDTO);
    return userDTO;
  }

  @GetMapping("/count")
  public Integer count() {
    return null;
  }

  @GetMapping("/get/{id}")
  public UserDTO get(@PathVariable Long id) {
    return this.userService.getById(id);
  }

  @GetMapping("/save")
  public Integer save() {
    return null;
  }

  @GetMapping("/update")
  public Integer update() {
    return null;
  }
}
