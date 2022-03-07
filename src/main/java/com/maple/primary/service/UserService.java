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
}
