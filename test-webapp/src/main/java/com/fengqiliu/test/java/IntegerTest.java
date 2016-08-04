package com.fengqiliu.test.java;

/**
 * Created by Administrator on 2015/12/10.
 */
public class IntegerTest {

    public static void main(String[] args) {
        int input = 1;

        int result = calFigure(input);


        System.out.println(result);
    }

    private static int max(int input) {
        int figure = calFigure(input);


        return 0;
    }

    private static int calFigure(int input) {
        if (input < 10) {
            return 1;
        }
        int figure = 0;
        for (int base = 1; base < input; figure++) {
            base = base * 10;
        }
        return figure;
    }

    private static Result analysis(int input) {

        Result result = new Result();
        result.setFigure(calFigure(input));
        result.setTopDigit(input / (int) Math.pow(10, result.figure));
        return result;
    }

    static class Result {
        private int figure;
        private int topDigit;
        private int halfOfBiggest;

        public int getFigure() {
            return figure;
        }

        public void setFigure(int figure) {
            this.figure = figure;
        }

        public int getHalfOfBiggest() {
            return halfOfBiggest;
        }

        public void setHalfOfBiggest(int halfOfBiggest) {
            this.halfOfBiggest = halfOfBiggest;
        }

        public int getTopDigit() {
            return topDigit;
        }

        public void setTopDigit(int topDigit) {
            this.topDigit = topDigit;
        }
    }

}
