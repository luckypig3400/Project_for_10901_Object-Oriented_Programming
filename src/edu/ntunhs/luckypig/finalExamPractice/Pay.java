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

    CreditCardsPay(User in_user) {
        user = in_user;
    }

    @Override
    int withdraw(int money) {
        if (money > 0 && money <= (user.creditCard1.creditLimit - user.creditCard1.usedAmount)) {
            user.creditCard1.usedAmount += money;
            user.creditCard1.creditLimit -= money;
            int trID = user.myLogList.size() + 1;
            addedBP = money / 1000 * 100;
            transactionLog = new UserLog(trID, transactionType, 0 - money, addedBP);
            user.myLogList.add(transactionLog);

            paymentStatus = 0;
        } else if (money > 0 && money > (user.creditCard1.creditLimit - user.creditCard1.usedAmount)) {
            paymentStatus = 1;
        } else if (money <= 0) {
            paymentStatus = 2;
        } else {
            paymentStatus = 3;
        }

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
    int depositStatus = 0;// 0:儲值成功 1:取消儲值 2:輸入金額有誤

    XDPay(User in_User) {
        user = in_User;
    }

    @Override
    public int withdraw(int money) {
        if (money > 0 && money <= user.balance) {
            user.balance -= money;
            int trID = user.myLogList.size() + 1;
            addedBP = money / 500 * 10;
            transactionLog = new UserLog(trID, transactionType, 0 - money, addedBP);
            user.myLogList.add(transactionLog);

            paymentStatus = 0;
        } else if (money > 0 && money > user.balance) {
            paymentStatus = 1;
        } else if (money <= 0) {
            paymentStatus = 2;
        } else {
            paymentStatus = 3;
        }

        return paymentStatus;
    }

    public int deposit(int money) {

        if (money > 0) {
            user.balance += money;
            int trID = user.myLogList.size() + 1;
            addedBP = money / 1000 * 100;
            transactionLog = new UserLog(trID, transactionType, money, addedBP);
            user.myLogList.add(transactionLog);

            depositStatus = 0;
        } else if (money == 0) {
            depositStatus = 1;
        } else {
            depositStatus = 2;
        }

        return depositStatus;
    }

    void addUserLog() {
        user.myLogList.add(transactionLog);
    }

    UserLog returnTransactionLog() {
        return transactionLog;
    }

    User returnCurrentUserStatus() {
        return user;
    }
}
