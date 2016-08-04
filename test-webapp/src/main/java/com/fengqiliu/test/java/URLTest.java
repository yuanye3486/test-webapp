package com.fengqiliu.test.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/1/18.
 */
public class URLTest {

    public static void main(String[] args) throws IOException {
        URLTest urlTest = new URLTest();
        urlTest.downloadFile();


    }

    private void downloadFile() throws IOException {
        URL url = new URL("http://localhost:8080/temp/waiting-deploy-files/2706_20160224160813/Script/����ͷ��_content_szp20160204.js");
        InputStream inputStream = url.openStream();
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Administrator.TRS-20140520WDQ\\Desktop/今日头条_content_szp20160204.js"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        inputStream.close();
        fos.close();
    }

}
