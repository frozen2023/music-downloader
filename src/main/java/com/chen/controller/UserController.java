package com.chen.controller;
import com.alibaba.fastjson.JSONObject;
import com.chen.pojo.User;
import com.chen.service.UserService;
import com.chen.common.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ReturnMsg<Map> register(@RequestBody String str)
    {
        Map<String,String> map= (Map<String,String>)JSONObject.parse(str);
        User user=new User();
        user.setUsername(map.get("username"));
        user.setPassword(map.get("password"));
        int result = userService.addUser(user);
        if(result>0) {
            Map mp=new HashMap<String,Object>();
            mp.put("id",user.getUserId());
            mp.put("username",user.getUsername());
            return new ReturnMsg<Map>().code(200).message("success").data(mp);
        }
        else {
           return new ReturnMsg<Map>().code(404);
        }
    }

    @PostMapping("/user/login")
    public ReturnMsg<Map> login(@RequestBody String str)
    {
        Map<String,String> map= (Map<String,String>)JSONObject.parse(str);
        String username=map.get("username");
        String password=map.get("password");
        Map m= userService.userLogin(username,password);
        if(m.get("msg").equals("success")) {
            return new ReturnMsg<Map>().code(200).message("success").data(m.get("data"));
        }
        else {
           return new ReturnMsg<Map>().code(404);
        }
    }


}
