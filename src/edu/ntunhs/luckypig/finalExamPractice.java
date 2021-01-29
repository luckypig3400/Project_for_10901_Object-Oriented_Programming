package edu.ntunhs.luckypig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class finalExamPractice {
    // this version won't modify base on teacher's code

    public static void main(String[] args) {
        File profile = new File(".\\profile.csv");
        User user1 = new User(profile);

        /*
         * 1.讀取個人資訊(Profile.txt)後(5%)，進入主程式提示使用者輸入密碼,當密碼正確時,
         * 登入成功後,畫面顯示「歡迎光臨{姓名},{姓名}需顯示自己的姓名,進入[主畫面]
         * 
         * 2.功能選單;密碼錯誤時,提示密碼錯誤並離開程式。其中Profile.txt可自行修改格式與設計
         * 
         * 3.主程式進入[主畫面]後,印出功能選項[1.查詢交易紀錄]、[2.儲值]、[3.付款]以及[4.離 開](5%),規格說明如下:
         * 
         * 4.按下數字[1]:查詢交易紀錄 4.l.l在UserLog類別中新增一個方法,將所有交易紀錄內容組合成一個文字字串並回
         * 傳,格式可自訂。其中日期格式為yyyyMMddHHmmss(5%) 並在main程式中將所有的交易紀錄逐筆顯示在畫面上,並跳回主畫面(5%)
         * 
         * 5.按下數字[2]:儲值,在主畫面顯示XDPay內的餘額,提示使用者輸入金額,並在User類別中新增一個儲值功能,
         * 當執行儲值功能結束後,顯示餘額並跳回[主畫面](5%) 程式需判斷輸入金額為非整數或時,要回傳錯誤,需提示輸入錯誤,並停留在
         * 原本的功能,讓使用者能重新輸入;若不要儲值,則回到主畫面
         * 
         * 6.按下數字[3]:付款,在[主畫面]選擇付款方式後,輸入提款金額,並顯示交易結果後跳 回[主畫面]。若選擇XDPay則需結果需顯示剩餘儲值金額(5%)
         * 
         * 6.1以[主畫面]提示使用者可選擇XDPay或CreditCardSpay其中一種付款方式,並在
         * User類別中新增一個付款功能,用多型的方式實作兩種付款方式。(5%) *提示:Pay myPayl = new XDPay();
         * 程式需判斷輸入金額為非整數、負數或是提款金額大於餘款時,需提示輸入錯誤, 並停留在原本的功能,讓使用者能重新輸入;若不要付款,則回到[主畫面](5%)
         * 
         * 7.按下數字[4]:離開,出現提示訊息,詢問是否離開,輸入小寫y或大寫Y則離開程 式,若輸小寫n或大寫N則回到主畫面(5%)
         * 
         * 8.[主畫面]程式需判斷,輸入金額非1,2,3,4時,應提示使用者輸入錯誤,並提示停留在 原本的功能,讓使用者能重新輸入選項(5%)
         */
    }

}

class CreditCard {
    int creditLimit;
    int usedAmount;
    String expiryDate;

    int getCreditLimit() {
        return creditLimit;
    }

    String getExpiryDate() {
        return expiryDate;
    }

    int getUsedAmount() {
        return usedAmount;
    }

    String getAllinfos() {
        return creditLimit + "," + usedAmount + "," + expiryDate;
    }

    void printAllinfos() {
        System.out.println("信用額度:" + creditLimit + "\t已使用額度:" + usedAmount + "\t此卡到期日:" + expiryDate);
    }

}

class User {
    String id;
    String name;
    String password;
    int balance;
    int bonus;
    CreditCard creditCard1;
    boolean loginStatus;
    ArrayList<UserLog> myLogList;
    File profile;

    User(File in_profile) {
        profile = in_profile;
        readProfile();
    }

    User(String in_id, String in_name, String in_password, int in_balance, int in_bonus) {
        id = in_id;
        name = in_name;
        password = in_password;
        balance = in_balance;
        bonus = in_bonus;
    }

    User(String in_id, String in_name, String in_password, int in_balance, int in_bonus, CreditCard in_cC1) {
        id = in_id;
        name = in_name;
        password = in_password;
        balance = in_balance;
        bonus = in_bonus;
        creditCard1 = in_cC1;
    }

    int getUserLogCount() {
        return myLogList.size();
    }

    void readProfile() {

        try {
            // 建議使用BufferedReader來讀取
            // https://www.stackchief.com/blog/FileReader%20vs%20BufferedReader%20vs%20Scanner%20%7C%20Java
            FileReader freader = new FileReader(profile);
            BufferedReader bReader = new BufferedReader(freader);
            final String headString = "id,name,password,balance,bonus,creditLimit,usedAmount,expiryDate,transactionRecord";
            String cache;
            cache = bReader.readLine();

            if (cache.equals(headString)) {
                // System.out.println("檔案位於:" + profile.getAbsolutePath());// debug用
                System.out.println("存檔欄位資訊正確 將嘗試讀取存檔...");

                while (bReader.ready()) {
                    String line = bReader.readLine();
                    String[] data = line.split(",");

                    System.out.println("讀取出來的資訊如下:");
                    for (String element : data) {
                        System.out.println(element);
                    }

                }
                bReader.close();
            } else {
                System.out.println("存檔欄位資訊有誤 存檔可能已毀損，請洽客服人員並回報以下資訊:");
                System.out.println(profile.getAbsolutePath());
            }

        } catch (Exception e) {
            System.out.println("檔案讀取中發生錯誤錯誤訊息如下:" + e);
            e.printStackTrace();// 輸出詳細錯誤資訊
            System.out.println("存檔可能已毀損，請洽客服人員並回報以上錯誤資訊");
        }

    }

    void readProfile(File in_profile) {

    }

    int writeProfile() {
        // also create file at the same time(overwrite old profile)
        // maybe can write backup old profile in the future
        boolean success = false;

        if (success) {
            return 0;
        }

        else
            return -1;
    }

    int writeProfile(File in_profile) {
        // also create file at the same time(overwrite old profile)
        // maybe can write backup old profile in the future
        boolean success = false;

        if (success) {
            return 0;
        }

        else
            return -1;
    }

}

class UserLog {
    int transactionID;
    String transactionType;
    int transactionAmount;
    int gainedBonus;
    String transactionDate;
    // 日期格式為yyyyMMddHHmmss

    String getFullLog() {
        return transactionID + "," + transactionType + "," + transactionAmount + "," + gainedBonus + ","
                + transactionDate;
    }

    void printFullLog() {
        System.out.println("交易序號:" + transactionID + "\t交易類型:" + transactionType + "\t交易金額:" + transactionAmount
                + "\t獲得紅利:" + gainedBonus + "\t交易日期" + transactionDate);
    }
}

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

    @Override
    int withdraw(int money) {
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

    @Override
    public int withdraw(int money) {
        return paymentStatus;
    }

    public int deposit(int money) {

        return 0;
    }

    void addUserLog() {
        user.myLogList.add(transactionLog);
    }

    UserLog returnTransactionLog() {
        return transactionLog;
    }

}

/*
 * 題目:設計一個北護大會員(User)易付卡(XDPay)提供現金儲值與電子付款系統,並有個人紅利點
 * 數累積,可提供信用卡(CreditCardSpay)付款功能,可查詢個人交易紀錄(LogList)等。根據試卷提
 * 供之範例程式,改寫範例程式(可任意修改刪除),功能及配分說明如下:
 * 
 * 1設計類別XDPay的儲值deposit(請使用Interface實作)以及電子付款withdraw(請使用繼承 類別pay實作),規格如下:
 * l.l.ldeposit:當儲值成功,當筆儲值滿1000元,紅利增加100點,並回傳狀態;當儲
 * 值失敗,至少回傳2個失敗狀態,並在註解上加註失敗原因。(5分)
 * 1.1.2withdraw:當每次消費滿500元,紅利額外增加10點,並回傳狀態;當消費失敗, 至少回傳2個失敗狀態,並在註解上加註失敗原因。(5分)
 * 
 * 2設計類別CreditCardSpay信用卡付款功能withdraw(使用繼承類別Pay實作),規格如下:
 * 2.1.1當付款成功,當筆消費滿1000元,額外紅利增加100點,並回傳狀態。(5分)
 * 2.1.2當付款失敗,至少回傳2個失敗狀態,並在註解上加註失敗原因。(5分)
 * 
 * 3設計類別User的建構子功能,輸入引數為檔案名稱(Profile.txt),載入個人會員資訊,包含:
 * (1)個人基本資料以及(2)交易紀錄。在建構子進行物件初始,從檔案讀取資訊並完成資料 載入,初始化建構的User物件。規格如下:
 * 3.1設計Profile.txt內容,須將(1)個人基本資料以及(2)交易紀錄儲存至此檔案。(10分)
 * 3.2建構子:請設計一個建構子,並載入文字檔,將個人資料以及交易紀錄匯入至物件的屬
 * 性,屬性包含中使用者資訊,需至少包含:帳號、密碼、姓名、餘額、紅利點數等以及 交易紀錄清單(myLogList)(5分)。
 * 3.3建構子:從檔案讀取多筆交易紀錄(UserLog),需至少包含:編號、交易類型、交易金 額、獲得紅利以及交易時間等、並指派至myLogList(5分)
 * 
 * 4撰寫一個main程式,請根據規格修改main以及對應類別,說明如下:
 * 4.1讀取個人資訊(Profile.txt)後(5%)，進入主程式提示使用者輸入密碼,當密碼正確時,
 * 登入成功後,畫面顯示「歡迎光臨{姓名},{姓名}需顯示自己的姓名,進入[主畫面]
 * 功能選單;密碼錯誤時,提示密碼錯誤並離開程式。其中Profile.txt可自行修改格式與 設計(5%)
 * 4.2主程式進入[主畫面]後,印出功能選項[1.查詢交易紀錄]、[2.儲值]、[3.付款]以及[4.離 開](5%),規格說明如下:
 * 
 * 4.1按下數字[1]:查詢交易紀錄 4.l.l在UserLog類別中新增一個方法,將所有交易紀錄內容組合成一個文字字串並回
 * 傳,格式可自訂。其中日期格式為yyyyMMddHHmmss(5%) 4.1.2在main程式中將所有的交易紀錄逐筆顯示在畫面上,並跳回主畫面(5%)
 * 4.2按下數字[2]:儲值,在主畫面顯示XDPay內的餘額,提示使用者輸入金額,並在
 * User類別中新增一個儲值功能,當執行儲值功能結束後,顯示餘額並跳回[主畫面](5%)
 * 4.2.1程式需判斷輸入金額為非整數或時,要回傳錯誤,需提示輸入錯誤,並停留在 原本的功能,讓使用者能重新輸入;若不要儲值,則回到【主畫面Ⅱ5%)
 * 
 * 4.3按下數字[3]:付款,在[主畫面]選擇付款方式後,輸入提款金額,並顯示交易結果後跳 回[主畫面]。若選擇XDPay則需結果需顯示剩餘儲值金額(5%)
 * 4.3.1以主畫面]提示使用者可選擇XDPay或CreditCardSpay其中一種付款方式,並在
 * User類別中新增一個付款功能,用多型的方式實作兩種付款方式。(5%) *提示:Pay myPayl = new XDPay();
 * 4.3.2程式需判斷輸入金額為非整數、負數或是提款金額大於餘款時,需提示輸入錯誤,
 * 並停留在原本的功能,讓使用者能重新輸入;若不要付款,則回到[主畫面](5%)
 * 
 * 4.4按下數字[4]:離開,出現提示訊息,詢問是否離開,輸入小寫y或大寫Y則離開程 式,若輸小寫n或大寫N則回到主畫面(5%)
 * 
 * 4.5[主畫面]程式需判斷,輸入金額非1,2,3,4時,應提示使用者輸入錯誤,並提示停留在 原本的功能,讓使用者能重新輸入選項(5%)
 * 
 * 5 程式繳交:繳交兩個案,並上傳至iLMS作業區:(l)個人資訊檔(Profile.txt)以及(2)程式 碼全部存放一個檔案並命名為Exam.java。
 */