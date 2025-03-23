package com.chen.service;

import com.chen.pojo.History;
import com.chen.pojo.Song;
import com.chen.pojo.SongAndHistory;

import java.util.List;
import java.util.Map;

public interface HistoryService {
    public int addHistory(History history);
    public int delHistoryById(Long userId,int id);
    public int delHistoryByIdList(Long userId, List<Integer> list);
    public Map getHistoryByUserIdAndPage(Long userId, String page);
    public Song setHistoryFav(Long userId,int id,int fav);

}
