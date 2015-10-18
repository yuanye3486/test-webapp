package com.fengqiliu.test.algorithms;

public class Util {
    public static String EXCEPTION_MESSAGE = "";

    public static int[] stringToIntArray(String string) {
        String[] stringArray = string.split(",");
        int[] intArray = null;
        intArray = stringArrayToIntArray(stringArray);
        return intArray;

    }

    public static String intArrayToString(int[] intArray) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 1; i < intArray.length; i++) {
            buffer.append(intArray[i]).append(",");
        }
        buffer.delete(buffer.length() - 1, buffer.length());
        return buffer.toString();
    }

    private static int[] stringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length + 1];
        for (int i = 1; i < stringArray.length + 1; i++) {
            intArray[i] = Integer.parseInt(stringArray[i - 1].trim());
        }

        return intArray;
    }

}
