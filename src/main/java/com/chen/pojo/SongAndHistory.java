package com.chen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongAndHistory {
    private String name;
    private String artist;
    private String album;
    private String duration;
    private Integer fav;
    private String rid;
    private Integer id;
}
