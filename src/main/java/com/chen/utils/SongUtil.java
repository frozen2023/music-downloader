package com.chen.utils;

import com.alibaba.fastjson.JSONObject;
import com.chen.pojo.Song;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SongUtil {

    //根据key在酷我上爬取歌曲数据
    public static List<Song> getSongListByMsg(String text) {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://www.kuwo.cn/search/searchMusicBykeyWord?vipver=1&client=kt&ft=music&cluster=0&strategy=2012&encoding=utf8&rformat=json&mobi=1&issubtitle=1&show_copyright_off=1&pn=0&rn=20&all=" + URLtoUTF8.toUtf8String(text));
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
        httpGet.addHeader("Cookie", "Hm_lvt_cdb524f42f0ce19b169a8071123a4797=1735042588; HMACCOUNT=0711ABFD6406F640; _ga=GA1.2.1804589370.1735042588; _gid=GA1.2.1307221208.1735042588; Hm_lpvt_cdb524f42f0ce19b169a8071123a4797=1735043198; Hm_Iuvt_cdb524f42f23cer9b268564v7y735ewrq2324=na8efDxyXPRhZjcDfd63Nte6EjPZNmk4; _gat=1;");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            String str = EntityUtils.toString(entity);
            //System.out.println(str);
            Map<String, Object> map = (Map<String, Object>) JSONObject.parse(str);
            // System.out.println(map.get("abslist"));
            List<Map<String, Object>> slist = (List<Map<String, Object>>) map.get("abslist");
            List<Song> result = new ArrayList<Song>();
            for (Map<String, Object> sm : slist) {
                String duration = toTimeFormat(Integer.parseInt(sm.get("DURATION").toString()));
                String musicrid = sm.get("MUSICRID").toString();
                musicrid = musicrid.substring(musicrid.indexOf("_") + 1);
                Song newSong = new Song((String) sm.get("SONGNAME"), (String) sm.get("ARTIST"), (String) sm.get("ALBUM"), duration, musicrid);
                result.add(newSong);
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    //将秒数转换为标准时分秒格式
    public static String toTimeFormat(int t)
    {
        int h=t/3600;
        int m=t%3600/60;
        int s=t%60;
        String str="";
        if(h!=0)
        {
            if(h<10)
                str+="0"+h;
            else {
                str+=h;
            }
            str+=":";
        }
        if(m<10)
            str+="0"+m;
        else {
            str+=m;
        }
        str+=":";

        if(s<10)
            str+="0"+s;
        else {
            str+=s;
        }
        return str;
    }
}

