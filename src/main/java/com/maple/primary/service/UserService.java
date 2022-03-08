package com.maple.primary.service;

import com.maple.primary.dto.UserDTO;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/27-18:35
 * @since 1.8
 */
public interface UserService {
  UserDTO getById(Long id);

  UserDTO getByUsername(String username);

  UserDTO checkLogin(String username, String password) throws Exception;

  void changePassword(Long id, String oldPassword, String password) throws Exception;

  Long insert(UserDTO userDTO);

  void update(UserDTO userDTO);

  void delete(Long id);
}
