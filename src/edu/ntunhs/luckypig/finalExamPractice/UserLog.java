package edu.ntunhs.luckypig.finalExamPractice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserLog {
    int transactionID;
    String transactionType;
    int transactionAmount;
    int gainedBonus;
    String transactionDate;
    // 日期格式為yyyy/MM/dd HH:mm:ss

    UserLog(){
        
    }

    UserLog(int in_trID, String in_trType, int in_trAmount, int in_gainedBonus, String in_trDate) {
        transactionID = in_trID;
        transactionType = in_trType;
        transactionAmount = in_trAmount;
        gainedBonus = in_gainedBonus;
        transactionDate = in_trDate;
    }

    UserLog(int in_trID, String in_trType, int in_trAmount, int in_gainedBonus) {
        transactionID = in_trID;
        transactionType = in_trType;
        transactionAmount = in_trAmount;
        gainedBonus = in_gainedBonus;

        transactionDate = getCurrentTime();
    }

    String getFullLog() {
        return transactionID + "," + transactionType + "," + transactionAmount + "," + gainedBonus + ","
                + transactionDate;
    }

    void printFullLog() {
        System.out.println("交易序號:" + transactionID + "\t交易類型:" + transactionType + "\t交易金額:" + transactionAmount
                + "\t獲得紅利:" + gainedBonus + "\t交易日期:" + transactionDate);
    }

    String getCurrentTime() {
        // reference:
        // https://www.javatpoint.com/java-get-current-date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    void printCurrentTime() {
        // reference:
        // https://www.javatpoint.com/java-get-current-date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}