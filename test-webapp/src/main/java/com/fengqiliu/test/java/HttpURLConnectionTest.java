package com.fengqiliu.test.java;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/3/1.
 */
public class HttpURLConnectionTest {

    public static void main(String[] args) throws IOException {
        downloadByUrl();
    }

    private static void downloadByUrl() throws IOException {
        URL url = new URL("http://localhost:8080/temp/waiting-deploy-files/2706_20160301104303/Script/搜狐新闻客户端_content.js");
        InputStream fis = url.openStream();

        byte[] b = new byte[1024 * 1024];
        int j;
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\df.txt"));
        while ((j = fis.read(b)) != -1) {
            fos.write(b, 0, j);
            fos.flush();
        }
        fos.close();
        fis.close();
    }

    private static void downloadByHttpUrlConnection() throws IOException {
        URL url = new URL("http://localhost:8080/temp/waiting-deploy-files/2706_20160301104303/Script/搜狐新闻客户端_content.js");
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();

        huc.setConnectTimeout(3000);     //设置连接超时时间
        huc.setDoInput(true);                  //打开输入流，以便从服务器获取数据
        huc.setRequestMethod("GET");     //设置以Post方式提交数据
        huc.setUseCaches(false);               //使用Post方式不能使用缓存
        huc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//设置请求体的类型是文本类型

        if (huc.getResponseCode() != HttpURLConnection.HTTP_OK) {
            System.out.println(huc.getResponseCode());
        }
        InputStream fis = huc.getInputStream();

        byte[] b = new byte[1024 * 1024];
        int j;
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop\\df.txt"));
        while ((j = fis.read(b)) != -1) {
            fos.write(b, 0, j);
            fos.flush();
        }
        fis.close();
        fos.close();
        huc.disconnect();
    }
}
