package com.maple.primary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/2/9-20:27
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {
  private String username;
  private String password;
}
