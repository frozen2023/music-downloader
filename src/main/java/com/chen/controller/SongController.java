package com.chen.controller;

import com.chen.pojo.History;
import com.chen.pojo.User;
import com.chen.service.HistoryService;
import com.chen.service.SongService;
import com.chen.service.UserService;
import com.chen.utils.FileUtil;
import com.chen.common.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
public class SongController {

    @Autowired
    private SongService songService;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;


    @GetMapping("/search")
    public ReturnMsg<Map> search(String text)
    {
        Map map = songService.searchSongs(text);
        return new ReturnMsg<Map>().code(200).message("success").data(map);
    }

    @GetMapping("/search/download/{rid}")
    public void download (@PathVariable("rid") String rid, HttpServletResponse response, HttpServletRequest request) {
        FileUtil.writeFile(response,rid);
        History his = new History();
        Long userId= (Long) request.getAttribute("userId");
        his.setUserId(userId);
        his.setRid(rid);
        historyService.addHistory(his);
    }












}




