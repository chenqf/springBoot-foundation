package com.maple.primary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/26-15:55
 * @since 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDO {
  private Long id;
  private String username;
  private String name;
  private String random;
  private Integer status;
  private Boolean deleted;
  private Long createBy;
  private Long modifiedBy;
  private Date gmtCreate;
  private Date gmtModified;
}
