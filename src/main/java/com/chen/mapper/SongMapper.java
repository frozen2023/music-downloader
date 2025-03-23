package com.chen.mapper;

import com.chen.pojo.History;
import com.chen.pojo.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface SongMapper {
    public int addSong(Song song);
    public Song getSongByRid(@Param("rid") String rid);
    // Song ifExist(@Param("rid") String rid);
}
