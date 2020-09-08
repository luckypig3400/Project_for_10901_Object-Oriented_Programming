package edu.ntunhs.luckypig;

import java.util.Scanner;

public class judgeScoreGrade {
    public static void main(String[] args) {
        Scanner score_in = new Scanner(System.in);
        System.out.println("請輸入您的成績，將會顯示對應的等級與表現:");
        try {
            int score = score_in.nextInt();
            if (score >= 90 && score <= 100) {
                System.out.println("等級:A\t表現:極佳");
            } else if (score >= 80 && score <= 89) {
                System.out.println("等級:B\t表現:佳");
            } else if (score >= 70 && score <= 79) {
                System.out.println("等級:C\t表現:平均");
            } else if (score >= 60 && score <= 69) {
                System.out.println("等級:D\t表現:差");
            } else if (score >= 0 && score <= 59) {
                System.out.println("等級:F\t表現:不及格");
            } else
                System.out.println("請輸入介於0~100的整數");
        } catch (Exception e) {
            System.out.println("請您輸入大於0且小於100的\"整數\"");
        }
        score_in.close();
    }
}

/*
 * 題目: 物件導向程式設計成績分數與成績等級的關係如表。寫一個程式，輸入數字成績，輸出成績等級以及對應表現。 分數 90-100 80-89 70-79
 * 60-69 0-59 等級 A B C D F 表現 極佳 佳 平均 差 不及格
 */