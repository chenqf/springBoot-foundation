package com.maple.primary.mapper;

import com.maple.primary.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/26-17:59
 * @since 1.8
 */
@Mapper
public interface UserMapper {
  UserDO getById(@Param("id") Long id);
}
