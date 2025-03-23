package com.chen.service;

import com.chen.mapper.HistoryMapper;
import com.chen.pojo.History;
import com.chen.pojo.Song;
import com.chen.pojo.SongAndHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    private HistoryMapper historyMapper;
    @Override
    public int addHistory(History history) {

        if(historyMapper.ifExist(history)==null){
            int id = historyMapper.countByUserId(history.getUserId())+1;
            history.setId(id);
            return historyMapper.addHistory(history);
        }
        return 1;
    }

    @Override
    public int delHistoryById(Long userId, int id) {
        return historyMapper.deleteHistoryById(userId,id);
    }
    public int delHistoryByIdList(Long userId, List<Integer> list)
    {
        int r=0;
        for (Integer id : list) {
              if(delHistoryById(userId,id)==0)
                  return 0;
              r++;
        }
        return r;
    }

    @Override
    public Map getHistoryByUserIdAndPage(Long userId, String page) {
        Map map=new HashMap();
        int start = (Integer.parseInt(page)-1)*10;
        int total = historyMapper.countByUserId(userId);
        int count;
        if(total % 10 != 0)
            count=total/10 + 1;
        else{
            count=total/10;
        }
        map.put("count",count);
        List<SongAndHistory> list  = historyMapper.getHistoryByUserIdAndPage(userId, start);
        System.out.println(list);
        map.put("list",list);
        return map;
    }

    @Override
    public Song setHistoryFav(Long userId, int id, int fav) {
        int i = historyMapper.setHistoryFav(userId, id, fav);
        Song song =null;
        if(i>0)
        {
            song=historyMapper.getSongMsgById(userId,id);
        }
        return song;
    }
}
