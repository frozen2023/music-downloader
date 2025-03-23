package com.chen.mapper;

import com.chen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public User getUserByName(@Param("username") String username);
}
