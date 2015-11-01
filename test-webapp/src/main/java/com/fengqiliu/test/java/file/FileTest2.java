package com.fengqiliu.test.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by LiuFengqi on 2015/10/25.
 */
public class FileTest2 {
    public static void main(String[] ags) {
        String dirPath = "C:\\Users\\LiuFengqi\\Desktop\\source";
        File dir = new File(dirPath);
        if (!dir.isDirectory()) {
            System.out.println(dirPath + "  不是一个文件夹！");
        }

        transEncode(dir);
    }

    public static void transEncode(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                transEncode(file);
            }
        } else {
            transGB2312ToUTF8(dir);
        }
    }

    private static void transGB2312ToUTF8(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String destDirName = file.getParent();
            destDirName = destDirName.replace("\\src", "");
            destDirName = destDirName.replace("source", "trans-source");
            File destDir = new File(destDirName);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(destDirName + "\\" + file.getName());
            byte[] buffer = new byte[1024];
            int readLength = 0;
            while ((readLength = fis.read(buffer)) != -1) {
                byte[] newBuffer = new String(buffer, 0, readLength, "GB2312").getBytes("utf-8");
                fos.write(newBuffer, 0, newBuffer.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
