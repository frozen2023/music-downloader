package com.chen.mapper;

import com.chen.pojo.History;
import com.chen.pojo.Song;
import com.chen.pojo.SongAndHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HistoryMapper {
    public int addHistory(History history);
    public int countByUserId(@Param("userId") Long userId);
    public History ifExist(History history);
    public int deleteHistoryById(@Param("userId") Long userId,@Param("id") int id);
    public List<SongAndHistory> getHistoryByUserIdAndPage(@Param("userId") Long userId,@Param("start") int start);
    public int setHistoryFav(@Param("userId")Long userId,@Param("id")int id,@Param("fav")int fav);
    public Song getSongMsgById(@Param("userId")Long userId,@Param("id")int id);
}
