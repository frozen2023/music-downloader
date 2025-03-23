package com.chen.service;

import com.chen.pojo.User;

import java.util.Map;

public interface UserService {
    public int addUser(User user);
    public Map<String,Object> userLogin(String username, String password);
}
