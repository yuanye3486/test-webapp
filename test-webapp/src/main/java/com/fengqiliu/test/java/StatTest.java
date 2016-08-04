package com.fengqiliu.test.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/19.
 */
public class StatTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    public static void main(String[] args) throws ParseException {
        String[][] data = {
                {"2015/01/01 02:00", "2015/01/02 01:00"},
                {"2015/01/01 12:00", "2015/01/01 23:00"},
                {"2015/01/02 11:00", "2015/01/03 01:00"},
                {"2015/01/03 12:00", "2015/01/04 01:00"}
        };

        int point[][] = new int[5][24];
        Calendar beginCal = Calendar.getInstance();
        for (int row = 0; row < data.length; row++) {
            Date beginTime = sdf.parse(data[row][0]);
            beginCal.setTime(beginTime);
            Date endTime = sdf.parse(data[row][1]);

            while (beginCal.getTime().compareTo(beginTime) >= 0 && beginCal.getTime().compareTo(endTime) <= 0) {
                int targetRowIndex = beginCal.get(Calendar.DAY_OF_MONTH) - 1;
                int targetColIndex = beginCal.get(Calendar.HOUR_OF_DAY);
                point[targetRowIndex][targetColIndex] = point[targetRowIndex][targetColIndex] + 1;
                beginCal.add(Calendar.HOUR_OF_DAY, 1);
            }
        }

        int totalRepeatPoint = 0;
        for (int row = 0; row < point.length; row++) {
            for (int col = 0; col < point[row].length; col++) {
                if (point[row][col] > 1) {
                    int day = row + 1;
                    int hour = col;
                    int repeatCount = point[row][col] - 1;
                    System.out.println(day + "号" + hour + "点重复" + repeatCount + "次。");
                    totalRepeatPoint++;
                }
            }
        }
        System.out.println("全部重复的整点数：" + totalRepeatPoint);
    }

}

