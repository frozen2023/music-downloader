package com.chen;

import com.chen.mapper.HistoryMapper;
import com.chen.mapper.UserMapper;
import com.chen.pojo.Song;
import com.chen.service.HistoryService;
import com.chen.service.SongService;
import com.chen.service.UserService;
import com.chen.utils.SongUtil;
import com.chen.utils.TokenUtil;
import org.apache.hc.core5.http.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class MusicplayerApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SongService songService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private HistoryMapper historyMapper;
    @Test
    void contextLoads() throws IOException, ParseException {

        /*User user=new User();
        user.setUsername("chenzhihang");
        user.setPassword("123456789");
        user.setUserId(10);

        System.out.println(userService.userLogin("frozen","200309czh"));*/
        SongUtil.getSongListByMsg("吴青峰");
        /*History history =new History();
        history.setRid(150210790);
        history.setUserId(16);
        historyService.addHistory(history);*/


        /*List<SongAndHistory> list = historyMapper.getHistoryByUserIdAndPage(16, 0);
        for (SongAndHistory songAndHistory : list) {
            System.out.println(songAndHistory);*/


       /* Map map = historyService.getHistoryByUserIdAndPage(15, "1");
        System.out.println(JSONObject.toJSONString(map));
        {"count":2,"list":[{"album":"裹着心的光Light of Sanctuary","artist":"林俊杰","duration":"04:33","fav":0,"id":1,"name":"裹着心的光","rid":180857894},{"album":"第二天堂","artist":"林俊杰","duration":"04:29","fav":0,"id":2,"name":"江南","rid":93157},{"album":"第二天堂","artist":"林俊杰","duration":"04:14","fav":0,"id":3,"name":"美人鱼","rid":93151},{"album":"新地球 - 人 (Special Edition)","artist":"林俊杰","duration":"04:58","fav":0,"id":4,"name":"可惜没如果","rid":6182865},{"album":"因你 而在","artist":"林俊杰","duration":"04:47","fav":0,"id":5,"name":"修炼爱情","rid":3244328},{"album":"曹操","artist":"林俊杰","duration":"04:02","fav":0,"id":6,"name":"曹操","rid":125802},{"album":"JJ陆","artist":"林俊杰","duration":"04:41","fav":0,"id":7,"name":"醉赤壁","rid":438658},{"album":"她说 概念自选辑","artist":"林俊杰","duration":"05:20","fav":0,"id":8,"name":"她说","rid":891712},{"album":"","artist":"林俊杰","duration":"04:57","fav":0,"id":9,"name":"起风了","rid":203308002},{"album":"新地球 - 人 (Special Edition)","artist":"林俊杰","duration":"04:37","fav":0,"id":10,"name":"新地球","rid":6125731},{"album":"JJ陆","artist":"林俊杰","duration":"03:55","fav":0,"id":12,"name":"不潮不用花钱","rid":442549},{"album":"JJ陆","artist":"林俊杰","duration":"03:55","fav":0,"id":11,"name":"不潮不用花钱","rid":442549}]}
    */
      /*  List<Song> songs = songService.searchSongs("周杰伦");
        Map map =  new HashMap();
        map.put("list",songs);
        System.out.println(new ReturnMsg().code(200).message("success").data(map).toJSONString());*/
       /* System.out.println(JSONObject.toJSONString(new MyData(15,"chen")));*/
       // System.out.println(historyMapper.deleteHistoryById(113127675589169152L, 1));
    }

}
