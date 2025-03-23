package com.chen;


import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        /*CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet=new HttpGet("https://www.kuwo.cn/api/www/search/searchMusicBykeyWord?key="+URLtoUTF8.toUtf8String("林俊杰") +"&pn=1&rn=20&httpsStatus=1&reqId=7234cbf0-add7-11ed-b4d7-21f64b81f17e");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
        httpGet.addHeader("Referer","https://www.kuwo.cn/search/list?key=%E6%9E%97%E4%BF%8A%E6%9D%B0");
        httpGet.addHeader("csrf", "XK3EKQYV1FS");
        httpGet.addHeader("Cookie","_ga=GA1.2.1226683575.1676419745; Hm_lvt_cdb524f42f0ce19b169a8071123a4797=1676419745,1676514174; _gid=GA1.2.1042470915.1676514174; gtoken=o4aqL0RurafQ; gid=8e0455db-69e6-41bf-b7f4-09f31f2b38a8; Hm_lpvt_cdb524f42f0ce19b169a8071123a4797=1676531610; kw_token=XK3EKQYV1FS; _gat=1");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        String str=EntityUtils.toString(entity);
        System.out.println(str);
        Map<String,Object> map = (Map<String, Object>) JSONObject.parse(str);
        //System.out.println(map.get("data"));
        Map<String,Object>map1= (Map<String, Object>) map.get("data");

        List<Map<String,Object>> list = (List<Map<String, Object>>)map1.get("list");
        for (Map<String, Object> sm : list) {
            System.out.println(sm.get("name")+" "+sm.get("artist")+" "+sm.get("album")+" "+sm.get("duration")+" "+sm.get("rid"));
        }
*/

       /* System.out.println(URLtoUTF8.toUtf8String("dash陈 志 航"));*/
        /*JSONObject o =new JSONObject();
        Map map =new HashMap();
        List<Song> list =new ArrayList<>();
        list.add(new Song("交换余生","林俊杰","交换余生","03:47",1555));
        map.put("list",list);

        o.put("data",map);
        System.out.println(o.toJSONString());*/
        /*System.out.println(JSONObject.toJSONString(new ReturnMsg().Code(200).Message("success")));*/
    }
}
