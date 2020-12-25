package edu.ntunhs.luckypig;

import java.io.File;

public class fakePxPay_20201225 {
    public static void main(String[] args) {

    }
}

abstract class PaymentSystem {

    private String ID, Name, PWD;
    File profile = new File("Profile.txt");
    int balance;
    int bonusPoint;

    // CreditCard card1 = new CreditCard(String card1Number);
    // maybe someday this will be useful

    PaymentSystem() {// provide default account
        ID = "082214226";
        Name = "楊曜承";
        PWD = "226";
        balance = 60000;
        bonusPoint = 0;
    }

    PaymentSystem(String in_ID, String in_Name, String in_PWD) {
        ID = in_ID;
        Name = in_Name;
        PWD = in_PWD;
        balance = 0;
        bonusPoint = 0;
    }

    PaymentSystem(String in_ID, String in_Name, String in_PWD, int in_balance, int in_BP) {
        ID = in_ID;
        Name = in_Name;
        PWD = in_PWD;
        balance = in_balance;
        bonusPoint = in_BP;
    }

    void readFile() {
        if(profile.exists()){
            //TODO: 讀取檔案
        }
    }

    void writeFile() {
        try {
            //TODO: 按照自訂規則寫入檔案儲存
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    int login(String in_ID, String in_PWD) {
        if (in_ID.equals(ID) && in_PWD.equals(PWD))
            return 1;
        else
            return 0;
    }

    void cashPay(int in_paymentAmount) {
        if (in_paymentAmount > 0) {
            System.out.println("收您現金:" + in_paymentAmount + "元");
            // 直接收現金不影響帳戶餘額
            bonusPoint += in_paymentAmount / 100;// 現金消費100元1點
        } else {
            System.out.println("請輸入正確金額");
        }
    }

    void ePay(int in_paymentAmount) {
        if (balance >= in_paymentAmount && in_paymentAmount > 0) {
            System.out.println("收您:" + in_paymentAmount + "元");
            balance -= in_paymentAmount;
            System.out.println("您的電子錢包餘額剩餘:" + balance + "元");
            bonusPoint += in_paymentAmount / 50;// 電子錢包餘額消費50元1點
        } else if (in_paymentAmount <= 0)
            System.out.println("請輸入正確金額");
        else
            System.out.println("餘額不足 請儲值或改用其他付款方式");
    }

    void creditCardPay(int in_paymentAmount) {
        if (in_paymentAmount > 0) {
            System.out.println("透過信用卡收您:" + in_paymentAmount + "元，請留意信用卡帳單");
            bonusPoint += in_paymentAmount / 50;// 刷信用卡消費50元1點
        } else
            System.out.println("請輸入正確金額");
    }

    void selectPaymentMethod(int in_paymentMethod, int in_paymentAmount) {
        switch (in_paymentMethod) {
            case 1:
                cashPay(in_paymentAmount);
                break;

            case 2:
                ePay(in_paymentAmount);
                break;

            case 3:
                creditCardPay(in_paymentAmount);
                break;

            default:
                System.out.println("付款方式選擇錯誤!");
                break;
        }
    }

    void printAccountInfo() {
        System.out.println(Name + "您好，您的帳戶編號為:" + ID + "\n電子錢包餘額剩餘:" + balance + "元\t" + "紅利點數:" + bonusPoint + "點");
    }

    String getAccountInfo() {
        String output = Name + "您好，您的帳戶編號為:" + ID + "\n電子錢包餘額剩餘:" + balance + "元\t" + "紅利點數:" + bonusPoint + "點";
        return output;
    }

    void cashDeposit(int in_depositAmount) {
        if (in_depositAmount > 0) {
            System.out.println("使用現金:" + in_depositAmount + "元為您的電子錢包儲值");
            balance += in_depositAmount;
            bonusPoint += in_depositAmount / 100;// 現金儲值100元1點
            System.out.println("您的電子錢包餘額剩餘:" + balance + "元");
        } else {
            System.out.println("請輸入正確金額");
        }
    }

    void creditCardDeposit(int in_depositAmount) {
        if (in_depositAmount > 0) {
            System.out.println("透過信用卡收取:" + in_depositAmount + "元為您的電子錢包儲值\n請留意信用卡帳單");
            balance += in_depositAmount;
            bonusPoint += in_depositAmount / 50;// 信用卡儲值50元1點
            System.out.println("您的電子錢包餘額剩餘:" + balance + "元");
        } else
            System.out.println("請輸入正確金額");
    }

    void selectDepositMethod(int in_depositMethod, int in_depositAmount) {
        switch (in_depositMethod) {
            case 1:
                cashDeposit(in_depositAmount);
                break;

            case 2:
                creditCardDeposit(in_depositAmount);
                break;

            default:
                System.out.println("儲值方式選擇錯誤!");
                break;
        }
    }

}

interface TransactionRecordSystem {

    void searchTransactionRecord();

    void addTransactionRecord();
    // 資料輸入格式是否正確後 呼叫writeFile寫入檔案

}

class PxPaySystem extends PaymentSystem implements TransactionRecordSystem {

    PxPaySystem() {
        super();
    }

    @Override
    public void searchTransactionRecord() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTransactionRecord() {
        // TODO Auto-generated method stub

    }

}

/*
 * 題目：請設計一個PX Pay系統，提供現金儲值與電子付款系統，並有個人紅利點數累積，可提供信用卡支付以及儲值金支付功能，可查詢個人交易紀錄。 1.
 * 請設計類別: 需使用繼承以及介面方式實作，並設計類別架構 - 個人帳號、付款方式、交易紀錄
 * 
 * 2. 並新增一個檔案(Profile.txt)儲存上述個人資訊以及交易紀錄，程式啟動時可讀取檔案，並啟動登入畫面。
 * 
 * 3. 請寫出主程式 ，使用個人帳密登入後，進入主畫面，並完成以下規則
 * 
 * 3.1 讀取Profile.txt後，進入主程式提示使用者輸入密碼，當密碼正確時，登入成功後，畫面顯示「歡迎光臨
 * {姓名}」，{姓名}需顯示自己的姓名，進入[主畫面]功能選單；密碼錯誤時，提示密碼錯誤並離開程式。其中Profile.txt可自行修改格式與設計
 * 
 * 3.2 主程式進入[主畫面]後，顯示紅利點數，並印出功能選項[1.查詢交易紀錄]、[2.儲值]、[3.付款] ]以及[4.離開] ，參考全聯Px
 * Pay畫面
 */