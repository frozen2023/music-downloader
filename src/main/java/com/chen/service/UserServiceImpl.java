package com.chen.service;

import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import com.chen.utils.SnowFlakeUtil;
import com.chen.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        if(userMapper.getUserByName(user.getUsername())!=null)
            return 0;
        user.setUserId(SnowFlakeUtil.getSnowFlakeId());
        int result=userMapper.addUser(user);
        return result;
    }
    @Override
    public Map<String,Object> userLogin(String username, String password) {

        Map map=new HashMap<String,Object>();
        User user = userMapper.getUserByName(username);
        if (user!=null)
        {
            if (password.equals(user.getPassword()))
            {
                map.put("msg","success");
                Map mp = new HashMap();
                mp.put("id",user.getUserId());
                mp.put("username",user.getUsername());
                mp.put("token", TokenUtil.createToken(user.getUserId()));
                map.put("data",mp);
                System.out.println(map.toString());
                return map;
            }
        }
        map.put("msg","fail");
        return map;
    }
}
