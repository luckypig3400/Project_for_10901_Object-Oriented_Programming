package edu.ntunhs.luckypig;

import java.util.*;

public class jugdeScoreYuJen {
    public static void main(String[] args) throws InterruptedException {
        int score = -200;
        int isPass = 1;

        System.out.print("開始測試:\r\n");
        while (score <= 200) {
            String result;
            result = score(score);

            if (result.equals("等級：A   表現：不及格")) {
                System.out.print("正確，此級距等級為  A \n" + score);
                isPass = 1;
            } else if (result.equals("等級：B   表現：不及格")) {
                System.out.print("正確，此級距等級為  B \n" + score);
                isPass = 1;
            } else if (result.equals("等級：C   表現：不及格")) {
                System.out.print("正確，此級距等級為  C \n" + score);
                isPass = 1;
            } else if (result.equals("等級：D   表現：不及格")) {
                System.out.print("正確，此級距等級為  D \n" + score);
                isPass = 1;
            } else if (result.equals("等級：E   表現：不及格")) {
                System.out.print("正確，此級距等級為  E \n" + score);
                isPass = 1;
            } else if (result.equals("等級：F   表現：不及格")) {
                System.out.print("正確，此級距等級為  F \n" + score);
                isPass = 1;
            } else if (result.equals("輸入超出範圍")) {
                System.out.print("OOPS 抓到錯了! \n" + score + "\r\n");
                isPass = 0;
            }
            score++;
        }
        if (isPass == 1) {
            System.out.print("OH YA! ");
        } else {
            System.out.print("OH NO! ");
        }
    }

    private static String score(int score) throws InterruptedException {
        try {
            if (score >= 90 && score <= 100) {
                return "等級：A   表現：極佳";
            } else if (score >= 80 && score <= 89) {
                return "等級：B   表現：佳";
            } else if (score >= 70 && score <= 79) {
                return "等級：C   表現：平均";
            } else if (score >= 60 && score < 69) {
                return "等級：D   表現：差";
            } else if (score >= 6 && score <= 59) {
                return "等級：E   表現：不及格";
            } else if (score >= 0 && score <= 5) {
                return "等級：F   表現：不及格!";
            } else
                return "輸入超出範圍";
        } catch (InputMismatchException e) {
            return "輸入非整數";
        }
    }

}
