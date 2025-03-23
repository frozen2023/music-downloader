package com.chen.controller;

import com.alibaba.fastjson.JSONObject;
import com.chen.pojo.Song;
import com.chen.service.HistoryService;
import com.chen.service.UserService;
import com.chen.common.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @Autowired
    private UserService userService;


    @DeleteMapping("/user/history")
    public ReturnMsg delete(@RequestBody String param, HttpServletRequest request)
    {
        Map<String,Object>map = (Map<String, Object>) JSONObject.parse(param);
        int type = (int) map.get("type");
        Integer id = (Integer) map.get("id");
        List<Integer> list = (List<Integer>) map.get("list");
        Long userId= (Long) request.getAttribute("userId");
        int result = 0;
        if(type==0) {
            result = historyService.delHistoryById(userId,id);
        }
        if(type==1) {
            result = historyService.delHistoryByIdList(userId,list);
        }
        ReturnMsg msg =new ReturnMsg();
        if(result > 0)
        {
            msg.code(200).message("success");
        }
        else{
            msg.code(404);
        }
        return msg;
    }

    @GetMapping("/user/history")
    public ReturnMsg<Map> getHistory(@RequestParam("page") String page,HttpServletRequest request)
    {
        Long userId= (Long) request.getAttribute("userId");
        Map map = historyService.getHistoryByUserIdAndPage(userId, page);
        System.out.println(map.keySet());
        return new ReturnMsg().code(200).message("success").data(map);
    }


    @PutMapping("/user/history/lc")
    public ReturnMsg<Map> setHistoryFav(@RequestBody String str,HttpServletRequest request)
    {
        Map<String,Object> map = (Map<String, Object>) JSONObject.parse(str);
        int id = (int) map.get("id");
        int fav = (int) map.get("fav");
        Long userId = (Long) request.getAttribute("userId");
        Song song = historyService.setHistoryFav(userId, id, fav);
        return new ReturnMsg<Map>().code(200).message("success").data(song);
    }



}
