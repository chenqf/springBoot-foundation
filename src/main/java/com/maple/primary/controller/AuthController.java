package com.maple.primary.controller;

import com.maple.primary.base.exception.AuthException;
import com.maple.primary.base.utils.result.ResultBuilder;
import com.maple.primary.dto.UserDTO;
import com.maple.primary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/21-10:45
 * @since 1.8
 */
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired private UserService userService;

  @PostMapping("/login")
  public UserDTO login(UserDTO userDTO) throws Exception {
    return this.userService.checkLogin(userDTO.getUsername(), userDTO.getPassword());
  }

  @PostMapping("/changePassword")
  public void changePassword() throws Exception {
    log.info("{}", ResultBuilder.success("10"));
    throw new AuthException("12333331");
  }

  @GetMapping("/logout")
  public String logout() {
    return "1111111111";
  }
}
