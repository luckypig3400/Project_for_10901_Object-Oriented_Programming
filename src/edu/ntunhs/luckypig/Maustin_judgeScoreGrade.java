

import java.util.Scanner;

public class Maustin_judgeScoreGrade {
    public static void main(String[] args) {
        int y = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入你的成績:");
        y = scanner.nextInt();
        if (y >= 90 && y <= 100) {
            System.out.println("等級:A 表現:極佳");
        } else if (y >= 80 && y <= 89) {
            System.out.println("等級:B 表現:佳");
        } else if (y >= 70 && y <= 79) {
            System.out.println("等級:C 表現:平均");
        } else if (y >= 60 && y <= 69) {
            System.out.println("等級:D 表現:差");
        } else if (y >= 0 && y <= 59) {
            System.out.println("等級:F 表現:不及格");
        }
        scanner.close();

    }
}

/*
 * 題目: 物件導向程式設計成績分數與成績等級的關係如表。寫一個程式，輸入數字成績，輸出成績等級以及對應表現。 分數 90-100 80-89 70-79
 * 60-69 0-59 等級 A B C D F 表現 極佳 佳 平均 差 不及格
 */