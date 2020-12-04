package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

import javax.lang.model.util.ElementScanner6;

/* 電子錢包付費功能範例 */

public class NTUNHSpay {
    ATM eWalletPaymentOption1;
    ATM eWalletPaymentOption2;
    private int Bonus;

    NTUNHSpay() {
        eWalletPaymentOption1 = new NetworkATM();
        eWalletPaymentOption2 = new creditCard();
        // 父類別ATM可以使用子類別NetworkATM的方法與建構子
        // eWallet的資料型態為ATM 使用的建構子卻是 NetworkATM的建構子
        // 這樣的用法稱之為多型(Polymorphism)
        Bonus = 0;
    }

    int payment(int paymentAmount, int paymentOption) {
        if (paymentOption == 1) {
            if (eWalletPaymentOption1.withdraw(paymentAmount) == 1) {
                System.out.println("電子付款成功~! ");
                return 1;
            } else {
                return 0;
            }
        } else if (paymentOption == 2) {
            if (eWalletPaymentOption2.withdraw(paymentAmount) == 1) {
                System.out.println("電子付款成功~! ");
                return 1;
            } else {
                return 0;
            }
        } else
            return 0;
    }

    int Register(int openDepositAmount) {

        return 0;
    }

    int getBalance(int paymentOption) {
        if (paymentOption == 1) {
            return eWalletPaymentOption1.getBalance();
        } else if (paymentOption == 1) {
            return eWalletPaymentOption2.getBalance();
        } else
            return 0;
    }

    int getBonus() {
        return Bonus;
    }
}
