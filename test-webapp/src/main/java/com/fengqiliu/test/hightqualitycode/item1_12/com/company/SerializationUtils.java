package com.fengqiliu.test.hightqualitycode.item1_12.com.company;

import java.io.*;

/**
 * 序列化工具
 */
public class SerializationUtils {
    private static String FILE_NAME = "C:\\Users\\LiuFengqi\\Desktop\\output\\obj.bin";

    // 序列化
    public static void writeObject(Serializable s) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(s);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readObject() {
        Object obj = null;
        // 反序列化化
        try {
            ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
            obj = input.readObject();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
