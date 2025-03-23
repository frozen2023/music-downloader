package com.chen.service;

import com.chen.mapper.SongMapper;
import com.chen.pojo.Song;
import com.chen.utils.SongUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongMapper songMapper;
    @Override
    public Map searchSongs(String text) {
        List<Song> list = SongUtil.getSongListByMsg(text);
        for (Song song : list) {
            if(songMapper.getSongByRid(song.getRid())==null)
                songMapper.addSong(song);
        }
        Map map =new HashMap();
        map.put("list",list);
        return map;
    }
}
