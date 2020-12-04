package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

import java.util.Scanner;

public class teachersExampleCode {
    public static void main(String[] args) {
        NTUNHSpay myPay = new NTUNHSpay();
        Scanner myScan = new Scanner(System.in);
        int charge = 0;
        while (true) {
            System.out.println("請輸入付款金額(輸入0離開)");
            charge = myScan.nextInt();
            if (charge == 0)
                break;
            myPay.payment(charge);
            System.out.println("餘額: " + Integer.toString(myPay.getBalance()));
        }
        myScan.close();
    }
}


/* 電子錢包付費功能範例 */

class NTUNHSpay {
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
