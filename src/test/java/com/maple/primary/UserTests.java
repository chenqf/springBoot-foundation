package com.maple.primary;

import com.maple.primary.dto.UserDTO;
import com.maple.primary.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/3/7-12:59
 * @since 1.8
 */
@Slf4j
public class UserTests extends BaseTests {
  @Autowired private UserService userService;

  @Test
  @Rollback
  public void getById() {
    UserDTO user = this.userService.getById(1L);
    log.debug("你好 debug");
    log.info("你好 info");
    log.warn("你好 warn");
    log.error("你好 error");
    log.trace("你好 trace");
    System.out.println(user);
  }

  @Test
  public void insert() {
    UserDTO userDTO = new UserDTO();
    userDTO.setUsername("chen_qi_feng");
    userDTO.setName("云中桥");
    userDTO.setPassword("1006");
    this.userService.insert(userDTO);
  }

  @Test
  public void update() {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(14L);
    userDTO.setName("crh");
    this.userService.update(userDTO);
  }

  @Test
  public void login() throws Exception {
    String username = "chen_qi_feng";
    String password = "8888";
    System.out.println(this.userService.checkLogin(username, password));
  }

  @Test
  public void changePassword() throws Exception {
    this.userService.changePassword(14L, "8888", "88888");
  }
}
