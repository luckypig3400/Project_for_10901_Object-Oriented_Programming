package edu.ntunhs.luckypig;

public class fakePxPay_20201225 {
    public static void main(String[] args) {

    }
}

abstract class PaymentSystem {

    private String ID, Name, PWD;

    int balance;
    int bonusPoint;

    // CreditCard card1 = new CreditCard();
    // maybe some day this will be useful

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

    }

    void writeFile() {

    }

    void login() {

    }

    void cashPay() {

    }

    void ePay() {

    }

    void creditCardPay() {

    }

    void selectPaymentMethod() {

    }

}

interface TransactionRecordSystem {

    void searchTransactionRecord();

    void addTransactionRecord();
    // 資料輸入格式是否正確後 呼叫writeFile寫入檔案

}

class PxPaySystem extends PaymentSystem implements TransactionRecordSystem {

    PxPaySystem(){
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