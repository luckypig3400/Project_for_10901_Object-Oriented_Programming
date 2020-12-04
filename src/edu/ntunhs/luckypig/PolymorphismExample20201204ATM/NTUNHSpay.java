package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

/* 電子錢包付費功能範例 */

public class NTUNHSpay {
    ATM eWallet;
    private int Bonus;

    NTUNHSpay() {
        eWallet = new NetworkATM();
        // 父類別ATM可以使用子類別NetworkATM的方法與建構子
        // eWallet的資料型態為ATM 使用的建構子卻是 NetworkATM的建構子
        // 這樣的用法稱之為多型(Polymorphism)
        eWallet.SetBalance(6000);
        Bonus = 0;
    }

    int payment(int paymentAmount) {
        if (eWallet.withdraw(paymentAmount) == 1) {
            System.out.println("電子付款成功~! ");
            return 1;
        } else {
            return 0;
        }
    }

    int Register(int openDepositAmount) {

        return 0;
    }

    int getBalance() {
        return eWallet.getBalance();
    }
}
