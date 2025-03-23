package com.chen.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.chen.pojo.User;

import java.util.Date;

public class TokenUtil {

    public static String createToken(Long id) {
         String token = JWT.create()
                .withClaim("userId",id)//payload  //自定义用户名
                .withExpiresAt(new Date(new Date().getTime() + 86400000))//指定令牌过期时间
                .sign(Algorithm.HMAC256("cjksgjkkg74455"));//签名
        // System.out.println(token);
        return token;
    }
}
