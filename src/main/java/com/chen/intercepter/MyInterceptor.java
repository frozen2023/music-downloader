package com.chen.intercepter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chen.common.Constants;
import com.chen.common.ReturnMsg;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    private static String SIGNATURE = "cjksgjkkg74455";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ReturnMsg msg = new ReturnMsg();

        //拦截器取到请求先进行判断，如果是OPTIONS请求，则放行
        if("OPTIONS".equals(request.getMethod().toUpperCase())) {
            System.out.println("Method:OPTIONS");
            return true;
        }

        //令牌建议是放在请求头中，获取请求头中令牌
        String token = request.getHeader("Authorization");
        System.out.println("token:  " + token);

        try{
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
            Long userId=jwt.getClaim("userId").asLong();
            request.setAttribute("userId",userId);
            // System.out.println("userId:  " + userId);
            return true;//放行请求
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            msg.message("签名不一致");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            msg.message("token过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            msg.message("token算法不一致");
        } catch (Exception e) {
            e.printStackTrace();
            msg.message("token失效");
        }
        msg.code(Constants.CODE_ERROR);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(msg);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
