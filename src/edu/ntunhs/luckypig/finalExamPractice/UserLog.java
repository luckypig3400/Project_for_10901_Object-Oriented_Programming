package edu.ntunhs.luckypig.finalExamPractice;

public class UserLog {
    int transactionID;
    String transactionType;
    int transactionAmount;
    int gainedBonus;
    String transactionDate;
    // 日期格式為yyyyMMddHHmmss

    String getFullLog() {
        return transactionID + "," + transactionType + "," + transactionAmount + "," + gainedBonus + ","
                + transactionDate;
    }

    void printFullLog() {
        System.out.println("交易序號:" + transactionID + "\t交易類型:" + transactionType + "\t交易金額:" + transactionAmount
                + "\t獲得紅利:" + gainedBonus + "\t交易日期" + transactionDate);
    }
}