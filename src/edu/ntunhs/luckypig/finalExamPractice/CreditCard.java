package edu.ntunhs.luckypig.finalExamPractice;

public class CreditCard {

    int creditLimit;
    int usedAmount;
    String expiryDate;

    int getCreditLimit() {
        return creditLimit;
    }

    String getExpiryDate() {
        return expiryDate;
    }

    int getUsedAmount() {
        return usedAmount;
    }

    String getAllinfo() {
        return creditLimit + "," + usedAmount + "," + expiryDate;
    }

    void printAllinfo() {
        System.out.println("信用額度:" + creditLimit + "\t已使用額度:" + usedAmount + "\t此卡到期日:" + expiryDate);
    }

}
