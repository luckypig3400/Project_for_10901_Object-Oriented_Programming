package edu.ntunhs.luckypig.finalExamPractice;

import java.io.*;
import java.util.Scanner;

public class mainSystem {
    // this version won't modify base on teacher's code

    static File profile = new File(".\\profile.csv");
    static Scanner userInput = new Scanner(System.in);
    static String in_id, in_pwd, in_name;
    static User user1;

    public static void main(String[] args) {

        unitTest();

        if (profile.exists()) {// 已經有存檔的執行區塊
            System.out.println("找到存檔!正在嘗試讀取存檔...");
            user1 = new User(profile);
            System.out.println("按一下Enter來登入系統");

            loginXDPaySystem();

            systemMainScreen();

        } else {// 沒有存檔或存檔毀損引導使用者建立帳戶執行區塊區塊
            int first_deposit = 0, in_bonus = 0;

            System.out.println("沒有找到存檔，可能遺失存檔或首次使用本系統");
            System.out.println("將引導逐步您建立帳戶...");

            System.out.println("請輸入您的姓名:");
            in_name = userInput.nextLine();
            System.out.println("請輸入您想建立的帳號ID:");
            in_id = userInput.nextLine();
            System.out.println("請輸入您想建立的密碼:");
            in_pwd = userInput.nextLine();
            System.out.println("請輸入您開戶想存的金額(首除滿千送1000點數，也可輸入0不儲值):");
            try {
                first_deposit = userInput.nextInt();
                if (first_deposit < 0) {
                    first_deposit = 0;
                    System.out.println("您輸入的金額有誤，不能儲值負數喔!");
                } else if (first_deposit >= 1000) {
                    in_bonus += 1000;
                    in_bonus += (first_deposit - 1000) / 1000 * 100;
                    System.out.println("感謝您首儲1000元以上，日後儲值滿千贈送100點");
                }
            } catch (Exception e) {
                first_deposit = 0;
                System.out.println("您輸入的金額有誤，只能輸入數字喔!");
            }

            user1 = new User(in_id, in_name, in_pwd, first_deposit, in_bonus);
            System.out.println("帳號建立成功，您的帳號資訊如下，請檢查是否正確並牢記帳號與密碼:");
            user1.printAllinfo();

            loginXDPaySystem();

            systemMainScreen();

        }

        userInput.close();
    }

    public static void loginXDPaySystem() {
        // Finished 2.功能選單;密碼錯誤時,提示密碼錯誤並離開程式。其中Profile.txt可自行修改格式與設計
        int loginTryCount = 0;

        userInput.nextLine();// 修正奇怪的登入錯誤(首次登入無法讀取帳號)
        System.out.println("歡迎使用XDPay系統~請於下方先登入您的帳號～");
        while (!user1.loginStatus && loginTryCount < 3) {// main screen
            System.out.println("請輸入您的帳號:");
            in_id = userInput.nextLine();
            System.out.println("請輸入您的密碼:");
            in_pwd = userInput.nextLine();

            System.out.println(user1.login(in_id, in_pwd));
            if (user1.loginStatus) {
                System.out.println("尊貴的用戶 " + user1.name + " 您好! 歡迎使用XDPay支付系統");
            } else {
                loginTryCount += 1;
                if (loginTryCount == 3)
                    System.out.println("錯誤次數過多 暫時無法登入!");
                else
                    System.out.println("您還剩" + (3 - loginTryCount) + "次機會可嘗試登入");
            }
        }
    }

    public static void systemMainScreen() {
        int functionSelection = 0;

        if (user1.loginStatus == false) {
            System.out.println("您尚未登入 即將離開系統...");
            functionSelection = 4;
        }

        while (functionSelection != 4) {
            // Finished 3.主程式進入[主畫面]後,印出功能選項[1.查詢交易紀錄]、[2.儲值]、[3.付款]以及[4.離 開](5%),規格說明如下:
            System.out.println("歡迎使用XDPay支付系統 本系統提供以下服務\n[1.查詢交易紀錄]\t[2.儲值]\t[3.付款]\t[4.離 開]");
            System.out.println("請選擇您欲使用的服務:");

            try {
                functionSelection = userInput.nextInt();
            } catch (Exception e) {
                System.out.println("請輸入數字1~4喔!");
                functionSelection = 0;
                userInput.nextLine(); // 把scanner內的資料清空 避免造成無限迴圈
                // Reading input using Scanner causes an infinite loop in Java [duplicate]
                // https://stackoverflow.com/questions/26684729/reading-input-using-scanner-causes-an-infinite-loop-in-java
            }

            switch (functionSelection) {
                case 1:
                    // TODO 4.按下數字[1]:查詢交易紀錄 4.l.l在UserLog類別中新增一個方法,將所有交易紀錄內容組合成一個文字字串並回
                    // 傳,格式可自訂。其中日期格式為yyyyMMddHHmmss(5%) 並在main程式中將所有的交易紀錄逐筆顯示在畫面上,並跳回主畫面(5%)
                    break;

                case 2:
                    // TODO 5.按下數字[2]:儲值,在主畫面顯示XDPay內的餘額,提示使用者輸入金額,並在User類別中新增一個儲值功能,
                    // 當執行儲值功能結束後,顯示餘額並跳回[主畫面](5%) 程式需判斷輸入金額為非整數或時,要回傳錯誤,需提示輸入錯誤,並停留在
                    // 原本的功能,讓使用者能重新輸入;若不要儲值,則回到主畫面
                    break;

                case 3:
                    // TODO 6.按下數字[3]:付款,在[主畫面]選擇付款方式後,輸入提款金額,並顯示交易結果後跳
                    // 回[主畫面]。若選擇XDPay則需結果需顯示剩餘儲值金額(5%)

                    // TODO 6.1以[主畫面]提示使用者可選擇XDPay或CreditCardSpay其中一種付款方式,並在
                    // User類別中新增一個付款功能,用多型的方式實作兩種付款方式。(5%) *提示:Pay myPayl = new XDPay();
                    // 程式需判斷輸入金額為非整數、負數或是提款金額大於餘款時,需提示輸入錯誤, 並停留在原本的功能,讓使用者能重新輸入;若不要付款,則回到[主畫面](5%)
                    break;

                case 4:
                    // TODO 7.按下數字[4]:離開,出現提示訊息,詢問是否離開,輸入小寫y或大寫Y則離開程 式,若輸小寫n或大寫N則回到主畫面(5%)
                    break;
                default:
                    System.out.println("請輸入1、2、3、4的其中一項喔");
                    // Finished 8.[主畫面]程式需判斷,輸入金額非1,2,3,4時,應提示使用者輸入錯誤,並提示停留在 原本的功能,讓使用者能重新輸入選項(5%)
                    break;
            }
        }
        System.out.println("感謝您使用XDPay支付系統 歡迎再次使用ヾ(≧▽≦*)o");
        user1.loginStatus = false;// 使用者離開系統 標示為登出
    }

    public static void unitTest() {
        UserLog testlog = new UserLog(1, "XDPay", -3000, 300);
        testlog.printCurrentTime();
    }

}

/*
 * 經過初步整理的題目:
 * 
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