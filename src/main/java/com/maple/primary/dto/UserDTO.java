package com.maple.primary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/27-15:12
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
  private Long id;
  private String username;
  private String name;
  private Integer status;
  private String oldPassword;
  private String password;
  private String newPassword;
}
