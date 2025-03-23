package com.chen.utils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.net.URIBuilder;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

    //根据url在外链上下载歌曲并写入响应流里

    public static void writeFile(HttpServletResponse response, String rid)
    {
        String url = "https://link.hhtjim.com/kw/"+rid+".mp3";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {


            URIBuilder uriBuilder = new URIBuilder(url);

            HttpGet httpGet =new HttpGet(uriBuilder.build());

            httpResponse = httpClient.execute(httpGet);

            inputStream = httpResponse.getEntity().getContent();

            response.setContentType(httpResponse.getEntity().getContentType());

            outputStream=response.getOutputStream();

            int len = 0;
            byte[] data = new byte[9090];
            while ((len = inputStream.read(data)) > 0) {
                outputStream.write(data, 0, len);
            }
            outputStream.close();
            inputStream.close();
            httpClient.close();
            httpResponse .close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
