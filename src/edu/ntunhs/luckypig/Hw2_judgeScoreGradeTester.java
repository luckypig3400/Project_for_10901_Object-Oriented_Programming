package edu.ntunhs.luckypig;

public class Hw2_judgeScoreGradeTester {
    public static void main(String[] args) {
        judgeScoreGrade judge1 = new judgeScoreGrade();
        for (int i = -200; i <= 200; i++) {
            judge1.judgeScoreGradeFunction(i);
        }
        for (int ascii = 65; ascii <= 122; ascii++) {
            char c = (char)ascii;
            System.out.println(c);
            judge1.judgeScoreGradeFunction(c);
        }
    }
}

/*
 * 1. 使用函數的形式請將作業1改寫，並撰寫測試程式輸入成績，判斷上述1的程式邏輯是否正確 - 若程式正確，則顯示測試正確提示訊息 -
 * 若程式有誤，則顯示程式錯誤，標示輸入數值。 - 輸入包含: -(1)-200~200 -(2)-英文字母大寫與小寫的所有字元A~Z & a~z
 */