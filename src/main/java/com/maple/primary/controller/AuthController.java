package com.maple.primary.controller;

import com.maple.primary.base.exception.AuthException;
import com.maple.primary.base.utils.result.ResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/login")
  public void login() throws Exception {
    log.info("{}", ResultBuilder.success("10"));
    throw new AuthException("12333331");
  }

  @GetMapping("/logout")
  public String logout() {
    return "1111111111";
  }
}
