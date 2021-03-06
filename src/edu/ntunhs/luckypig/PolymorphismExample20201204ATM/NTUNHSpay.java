package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

/* 電子錢包付費功能範例 */

public class NTUNHSpay {
    ATM eWalletPaymentOption1;
    ATM eWalletPaymentOption2;
    private int Bonus;
    int defaultPaymentOption;

    NTUNHSpay() {
        eWalletPaymentOption1 = new NetworkATM();
        eWalletPaymentOption2 = new creditCard();
        // 父類別ATM可以使用子類別NetworkATM的方法與建構子
        // eWallet的資料型態為ATM 使用的建構子卻是 NetworkATM的建構子
        // 這樣的用法稱之為多型(Polymorphism)
        eWalletPaymentOption1.setBalance(6000);
        eWalletPaymentOption2.setBalance(6000);
        Bonus = 0;
        defaultPaymentOption = 1;// 預設使用網銀付款
    }

    int payment(int paymentAmount, int in_paymentOption) {

        // 在執行付款動作前先同步兩邊付款方式的餘額(因為使用的是同一間銀行的存款)
        if (eWalletPaymentOption1.getBalance() > eWalletPaymentOption2.getBalance())
            eWalletPaymentOption1.setBalance(eWalletPaymentOption2.getBalance());
        else // 選擇剩餘金額較少的為當前金額，並同步另一邊的餘額
            eWalletPaymentOption2.setBalance(eWalletPaymentOption1.getBalance());

        if (in_paymentOption == 1) {
            if (eWalletPaymentOption1.withdraw(paymentAmount) == 1) {
                System.out.println("使用綁定的網銀帳戶進行電子付款成功~! ");
                return 1;
            } else {
                return 0;
            }
        } else if (in_paymentOption == 2) {
            if (eWalletPaymentOption2.withdraw(paymentAmount) == 1) {
                System.out.println("使用綁定的信用卡進行電子付款成功~! ");
                return 1;
            } else {
                return 0;
            }
        } else
            return 0;
    }

    int payment(int paymentAmount) {

        // 在執行付款動作前先同步兩邊付款方式的餘額(因為使用的是同一間銀行的存款)
        if (eWalletPaymentOption1.getBalance() > eWalletPaymentOption2.getBalance())
            eWalletPaymentOption1.setBalance(eWalletPaymentOption2.getBalance());
        else // 選擇剩餘金額較少的為當前金額，並同步另一邊的餘額
            eWalletPaymentOption2.setBalance(eWalletPaymentOption1.getBalance());

        if (defaultPaymentOption == 1) {
            if (eWalletPaymentOption1.withdraw(paymentAmount) == 1) {
                System.out.println("使用綁定的網銀帳戶進行電子付款成功~! ");
                return 1;
            } else {
                return 0;
            }
        } else if (defaultPaymentOption == 2) {
            if (eWalletPaymentOption2.withdraw(paymentAmount) == 1) {
                System.out.println("使用綁定的信用卡進行電子付款成功~! ");
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

    int getBalance(int in_paymentOption) {
        if (in_paymentOption == 1) {
            return eWalletPaymentOption1.getBalance();
        } else if (in_paymentOption == 2) {
            return eWalletPaymentOption2.getBalance();
        } else
            return 0;
    }

    int getBalance() {
        if (defaultPaymentOption == 1) {
            return eWalletPaymentOption1.getBalance();
        } else if (defaultPaymentOption == 2) {
            return eWalletPaymentOption2.getBalance();
        } else
            return 0;
    }

    int getBonus() {
        return Bonus;
    }
}
