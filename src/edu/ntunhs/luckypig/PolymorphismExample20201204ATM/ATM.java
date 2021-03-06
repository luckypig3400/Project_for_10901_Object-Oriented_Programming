package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

public class ATM {
    private String ID, Name, PWD;
    int Balance;

    ATM() { // default Account (for test only)
        ID = "082214226";
        Name = "楊曜承";
        PWD = "226";
        Balance = 60000;
    }

    ATM(String in_ID, String in_Name, String in_PWD) {
        ID = in_ID;
        Name = in_Name;
        PWD = in_PWD;
        Balance = 0;
    }

    ATM(String in_ID, String in_Name, String in_PWD, int openingDeposit) {
        ID = in_ID;
        Name = in_Name;
        PWD = in_PWD;
        Balance = openingDeposit;// 開戶存入金額
    }

    int withdraw(int withdrawAmount) {
        if (0 > withdrawAmount)// 輸入金額錯誤，不可小於0
            return 0;
        if (Balance >= withdrawAmount) {
            Balance -= withdrawAmount;
            return 1;
        } else
            return 0;
    }

    void setBalance(int adjustedBalanceAmount) {
        Balance = adjustedBalanceAmount;
    }

    int getBalance() {
        return Balance;
    }

    String getAccountInfo() {
        return Name + "您好~ 您的帳號ID:" + ID + "剩餘餘額:" + Balance;
    }

    void printAccountInfo() {
        System.out.println(Name + "您好~ 您的帳號ID:" + ID + "剩餘餘額:" + Balance);
    }

    int login(String in_ID, String in_PWD) {
        if (in_PWD.equals(PWD)) {
            return 1;// login successful
        } else
            return 0;// login failed
    }

    void printATMmenu() {
        
    }
}
