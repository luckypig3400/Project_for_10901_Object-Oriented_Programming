package edu.ntunhs.luckypig.finalExamPractice;

abstract class Pay {
    /*
     * 此類別為抽象類別概述 系統PaySystem應該要 負責處理交易與回傳紀錄 paymentStatus //0付款成功 //1付款失敗:餘額不足
     * //2付款失敗:輸入金額數值錯誤 //3付款失敗:付款裝置感應失敗
     */
    int paymentStatus;

    int withdraw(int money) {
        return paymentStatus;
    }

    String returnLog() {
        return "transaction Log Maybe complete it in other class";
    }
}

interface Deposit {
    int deposit(int money);
}

class CreditCardsPay extends Pay {
    // withdraw:當每次消費 滿1000元, 紅利額外增加100點
    final String transactionType = "CreditCardsPay";
    User user;
    int addedBP;
    UserLog transactionLog;

    @Override
    int withdraw(int money) {
        return paymentStatus;
    }

    void addUserLog() {
        user.myLogList.add(transactionLog);
    }

    UserLog returnTransactionLog() {
        return transactionLog;
    }
}

class XDPay extends Pay implements Deposit {
    // deposit: 當儲值成功 單筆儲值滿1000元, 紅利增加100點 withdraw:當每次消費 滿500元,紅利 額外增加10點
    final String transactionType = "XDPay";
    User user;
    int addedBP;
    UserLog transactionLog;

    @Override
    public int withdraw(int money) {
        return paymentStatus;
    }

    public int deposit(int money) {

        return 0;
    }

    void addUserLog() {
        user.myLogList.add(transactionLog);
    }

    UserLog returnTransactionLog() {
        return transactionLog;
    }

}
