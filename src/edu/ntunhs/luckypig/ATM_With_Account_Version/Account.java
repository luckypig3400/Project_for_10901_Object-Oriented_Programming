package edu.ntunhs.luckypig.ATM_With_Account_Version;

public class Account {
    private String account;//this is account number (ID) should be the primary key in Database
    private String accountName;
    private String password;
    private int deposit;
    private int dailyWithdrawAmount;// 今日已提領金額
    private int dailyWithdrawLimit;// 今日提領上限

    Account() {// default account;
        account = "082214226";
        accountName = "楊曜承";
        password = "226";
        deposit = 66666;
        dailyWithdrawAmount = 0;
        dailyWithdrawLimit = 30000;
    }

    Account(String in_account, String in_accountName, String in_password, int in_deposit) {
        account = in_account;
        accountName = in_accountName;
        password = in_password;
        deposit = in_deposit;
        dailyWithdrawAmount = 0;
        dailyWithdrawLimit = 30000;
    }

    Account(String in_account, String in_accountName, String in_password, int in_deposit, int in_dailyWithdrawLimit) {
        account = in_account;
        accountName = in_accountName;
        password = in_password;
        deposit = in_deposit;
        dailyWithdrawAmount = 0;
        dailyWithdrawLimit = in_dailyWithdrawLimit;
    }

    void getAccountInfo() {
        System.out.println(accountName + "您好!\n您的帳戶編號為:" + account + "\n您的帳戶餘額剩餘:" + deposit + "\n您今日已經提領金額為:"
                + dailyWithdrawAmount + "元\n您的每日提領上限為:" + dailyWithdrawLimit);
    }

}

// TODO use this class to access SQL