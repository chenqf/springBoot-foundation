package com.maple.primary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author qifeng.b.chen
 * @since 2022-03-09 16:40:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
  private static final long serialVersionUID = -71125977487715282L;
  /** 主键 */
  private Long id;
  /** 用户名 */
  private String username;
  /** 密码 */
  private String password;
  /** 随机数用于生成密码 */
  private String random;
  /** 昵称 */
  private String name;
  /** 0:禁用;1启用 */
  private Integer status;
  /** 是否被删除 */
  private Boolean deleted;
  /** 创建人 */
  private Long createBy;
  /** 最后修改人 */
  private Long modifiedBy;
  /** 创建时间 */
  private Date gmtCreate;
  /** 最后修改时间 */
  private Date gmtModified;
}
