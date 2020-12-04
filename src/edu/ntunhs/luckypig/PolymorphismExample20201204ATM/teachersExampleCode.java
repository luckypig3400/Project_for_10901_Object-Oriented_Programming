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

class ATM {
    private String Name, ID, PWD;
    int Balance;

    int withdraw(int gMoney) {
        if (0 > gMoney)
            return 0;
        Balance += gMoney;
        return 1;
    }

    void SetBalance(int gMoney) {
        Balance += gMoney;
    }

    int getBalance() {
        return Balance;
    }
}

class NetworkATM extends ATM {
    private String Name, ID, PWD;
    private int Bonus = 0;

    /**
     * @param gMoney, 輸入存款金額
     * @return if true, 存款成功; false, 輸入錯誤
     */
    boolean deposit(int gMoney) {
        if (gMoney < 0) {
            return false; // 存款金額<0, 錯誤狀態
        } else { // 存款的動作
            Balance = Balance + gMoney; // Balance +=gMoney;
            Bonus += 7;
            System.out.println("NetworkATM 存款成功~! ");
            return true; // 存款成功狀態
        }
    }

    int withdraw(int gMoney) {
        if (0 > gMoney)
            return 0;
        Balance -= gMoney;
        Bonus += 7;
        return 1;
    }
}

/* 電子錢包付費功能範例 */

class NTUNHSpay {
    ATM eWallet;
    private int Bonus;

    NTUNHSpay() {
        eWallet = new NetworkATM();
        //父類別ATM可以使用子類別NetworkATM的方法與建構子
        //eWallet的資料型態為ATM 使用的建構子卻是 NetworkATM的建構子
        //這樣的用法稱之為多型(Polymorphism)
        eWallet.SetBalance(5000);
        Bonus = 0;
    }

    int payment(int gMoney) {
        if (eWallet.withdraw(gMoney) == 1) {
            System.out.println("電子付款成功~! ");
            return 1;
        } else {
            return 0;
        }
    }

    int Register(int gMoney) {
        return 0;
    }

    int getBalance() {
        return eWallet.getBalance();
    }
}
