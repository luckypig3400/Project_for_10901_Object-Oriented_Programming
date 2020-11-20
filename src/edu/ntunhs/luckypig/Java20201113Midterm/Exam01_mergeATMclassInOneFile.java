package edu.ntunhs.luckypig.Java20201113Midterm;

import java.util.Scanner;

public class Exam01_mergeATMclassInOneFile {
    public static void main(String[] args) throws InterruptedException {

        ATM myATM = new ATM();
        myATM.login();

        System.out.println("====================================");
        System.out.println("以下為加分題自動演示");
        System.out.println("====================================");
        System.out.println("自動登入:");
        Thread.sleep(600);
        myATM.login("082214226", "226");
        System.out.println("====================================");
        System.out.println("自動存款6000元:");
        Thread.sleep(600);
        myATM.deposit(6000);
        System.out.println("====================================");
        System.out.println("自動提款6000元:");
        Thread.sleep(600);
        myATM.withdraw(6000);
        System.out.println("====================================");
    }
}

class ATM {

    float balance;
    String accountName;
    String accountNumber;
    private String password;
    final float dailyWithdrawLimit = 30000;
    public float todayRemainWithdrawAmount;

    ATM() {// default: my account
        balance = 60000;
        accountName = "楊曜承";
        accountNumber = "082214226";
        password = "226";
        todayRemainWithdrawAmount = dailyWithdrawLimit;
    }

    ATM(String in_name, String in_accountNumber, String in_password, float in_balance) {// Let other User create their
                                                                                        // account
        accountName = in_name;
        accountNumber = in_accountNumber;
        password = in_password;
        balance = in_balance;
    }

    void login() throws InterruptedException {// 推薦使用此方法

        boolean loginStatus = false;
        int failedLoginCount = 0;
        Scanner userInputSC = new Scanner(System.in);
        String inputAccountNumer;
        String inputPWD;

        while (failedLoginCount < 3 && loginStatus == false) {
            System.out.println("請輸入您的帳號:");
            inputAccountNumer = userInputSC.nextLine();
            System.out.println("正在查詢是否有此帳號...");
            if (inputAccountNumer.equals(accountNumber)) {
                System.out.println("此帳號存在! 請輸入密碼:");
                inputPWD = userInputSC.nextLine();
                if (inputPWD.equals(password)) {
                    System.out.println("密碼正確無誤\n" + accountName + " 您好~ 歡迎使用本ATM服務!");
                    loginStatus = true;
                } else {
                    System.out.println("密碼有誤!請您重新輸入");
                    failedLoginCount += 1;
                }
            } else {
                System.out.println("此帳號不存在!請您重新輸入");
                failedLoginCount += 1;
            }
        }

        if (loginStatus == true) {
            System.out.println("登入成功!");
            ATMserviceMainScreen();// 成功登入進入ATM服務主頁面
        } else {
            System.out.println("密碼或帳號輸入錯誤次數過多，將離開系統...");
        }

    }

    boolean login(String inputAccountNumer, String inputPWD) {

        boolean loginStatus = false;
        Scanner userInputSC = new Scanner(System.in);

        if (inputAccountNumer.equals(accountNumber) && inputPWD.equals(password))
            loginStatus = true;// 使用外部傳入值一次就入成功

        int failedLoginCount = 1;// 若失敗則交給後面區塊進行處理並紀錄已經嘗試登入1次

        System.out.println("因為您傳入的值有誤，將改為互動模式來進行登入動作=>");

        while (failedLoginCount < 3 && loginStatus == false) {
            System.out.println("請輸入您的帳號:");
            inputAccountNumer = userInputSC.nextLine();
            System.out.println("正在查詢是否有此帳號...");
            if (inputAccountNumer.equals(accountNumber)) {
                System.out.println("此帳號存在! 請輸入密碼:");
                inputPWD = userInputSC.nextLine();
                if (inputPWD.equals(password)) {
                    System.out.println("密碼正確無誤\n" + accountName + " 您好~ 歡迎使用本ATM服務!");
                    loginStatus = true;
                } else {
                    System.out.println("密碼有誤!請您重新輸入");
                    failedLoginCount += 1;
                }
            } else {
                System.out.println("此帳號不存在!請您重新輸入");
                failedLoginCount += 1;
            }
        }

        if (loginStatus == true) {
            System.out.println("登入成功!");
            return loginStatus;// 僅回傳值，不呼叫主頁面
        } else {
            System.out.println("密碼或帳號輸入錯誤次數過多，將離開系統...");
            return loginStatus;// 回傳值(登入失敗)
        }

    }

    void ATMserviceMainScreen() throws InterruptedException {

        String funString = "0";

        while (funString.equals("6") == false) {// 當使用者沒有選擇離開則一直停留在主畫面
            System.out.println("====================================");
            System.out.println("您好本ATM提供以下幾項服務\n1.查詢餘額\t\t2.存款\t\t3.提款\n4.查詢今日可提款金額\t5.查詢營業時間\t6.離開");
            System.out.println("====================================");
            System.out.println("請選擇服務項目:");
            Scanner sc = new Scanner(System.in);
            funString = sc.nextLine();
            switch (funString) {
                case "1":
                    System.out.println("【您選擇了查詢餘額】");
                    getBalance();
                    Thread.sleep(900);
                    break;
                case "2":
                    System.out.println("【您選擇了存款】");
                    deposit();
                    Thread.sleep(900);
                    break;
                case "3":
                    System.out.println("【您選擇了提款】");
                    withdraw();
                    Thread.sleep(900);
                    break;
                case "4":
                    System.out.println("【您選擇了查詢今日可提款金額】");
                    getDailyRemainWithdrawAmount();
                    Thread.sleep(900);
                    break;
                case "5":
                    System.out.println("【您選擇了查詢營業時間】");
                    getBankOpeningTime();
                    Thread.sleep(900);
                    break;
                case "6":
                    System.out.println("【您選擇了離開】");
                    if (exit() == false)
                        funString = "0";
                    else {
                        // do nothing let the funString remain the original value
                    }
                    Thread.sleep(900);
                    break;
                default:
                    System.out.println("輸入有誤喔!將回到主畫面(小提示:不用輸入.)");
                    Thread.sleep(900);
                    break;
            }
        }
    }

    void getBalance() {
        System.out.println(accountName + " 您好!\n您的帳戶餘額剩餘:" + balance);
    }

    void deposit() {
        float depositAmount = 0;
        Scanner sc = new Scanner(System.in);

        try {
            while (depositAmount <= 0) {
                System.out.println("請輸入慾存款金額(輸入-1取消存款):");
                depositAmount = sc.nextFloat();
                if (depositAmount == -1) {
                    System.out.println("您已取消存款");
                    break;// 輸入-1取消存款
                } else if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.println("成功存入:" + depositAmount + "元");
                    System.out.println("目前餘額:" + balance + "元");
                } else {
                    System.out.println("請輸入大於0的整數喔!");
                }
            }
        } catch (Exception e) {
            System.out.println("輸入有誤，將返回主畫面(HINT:只能輸入數字喔!)");
        }
    }

    boolean deposit(float depositAmount) {
        if (depositAmount == -1) {
            System.out.println("您已取消存款");
            return false;
        } else if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("成功存入:" + depositAmount + "元");
            System.out.println("目前餘額:" + balance + "元");
            return true;
        } else {
            System.out.println("請輸入大於0的整數喔!");
            return false;
        }
    }

    void withdraw() throws InterruptedException {
        float withdrawAmount = 0;
        Scanner sc = new Scanner(System.in);

        try {
            while (withdrawAmount <= 0) {
                System.out.println("請輸入慾提款金額(輸入-1取消提款):");
                withdrawAmount = sc.nextFloat();
                if (withdrawAmount == -1) {
                    System.out.println("您已取消提款");
                    break;// 輸入-1取消提款
                } else if (withdrawAmount > 0) {
                    System.out.println("正在檢查帳戶餘額...");
                    Thread.sleep(300);
                    if (balance >= withdrawAmount) {
                        System.out.println("餘額足夠!正在核對日提款上限...");
                        Thread.sleep(300);
                        if (todayRemainWithdrawAmount >= withdrawAmount) {
                            balance -= withdrawAmount;
                            todayRemainWithdrawAmount -= withdrawAmount;
                            System.out.println("成功提款:\t" + withdrawAmount + "元");
                            System.out.println("目前餘額:\t" + balance + "元");
                            System.out.println("本日剩餘提領額:\t" + todayRemainWithdrawAmount + "元");
                        } else {
                            System.out.println("超過本日提領上限! 本日剩餘提領額:" + todayRemainWithdrawAmount);
                            System.out.println("請重新輸入本日提領上限內的金額!");
                        }
                    } else {
                        System.out.println("餘額不足!將返回主頁面");
                        break;
                    }

                } else {
                    System.out.println("請輸入大於0的整數喔!");
                }
            }
        } catch (Exception e) {
            System.out.println("輸入有誤，將返回主畫面(HINT:只能輸入數字喔!)");
        }
    }

    boolean withdraw(float withdrawAmount) throws InterruptedException {
        if (withdrawAmount == -1) {
            System.out.println("您已取消提款");
            return false;
        } else if (withdrawAmount > 0) {
            System.out.println("正在檢查帳戶餘額...");
            Thread.sleep(300);
            if (balance >= withdrawAmount) {
                System.out.println("餘額足夠!正在核對日提款上限...");
                Thread.sleep(300);
                if (todayRemainWithdrawAmount >= withdrawAmount) {
                    balance -= withdrawAmount;
                    todayRemainWithdrawAmount -= withdrawAmount;
                    System.out.println("成功提款:\t" + withdrawAmount + "元");
                    System.out.println("目前餘額:\t" + balance + "元");
                    System.out.println("本日剩餘提領額:\t" + todayRemainWithdrawAmount + "元");
                    return true;
                } else {
                    System.out.println("超過本日提領上限! 本日剩餘提領額:" + todayRemainWithdrawAmount);
                    System.out.println("請重新輸入本日提領上限內的金額!");
                    return false;
                }
            } else {
                System.out.println("餘額不足!將返回主頁面");
                return false;
            }

        } else {
            System.out.println("請輸入大於0的整數喔!");
            return false;
        }

    }

    void getDailyRemainWithdrawAmount() {
        System.out.println(accountName + "您好!\n您的帳戶餘額剩餘:" + balance + "\n今日可提款金額剩餘:" + todayRemainWithdrawAmount);
    }

    static void getBankOpeningTime() {
        System.out.println("本銀行的營業時間為周一至周五上午9點至下午3點");
        System.out.println("本ATM的營業時間為24小時全年無休，歡迎多加使用");
    }

    boolean exit() {
        String areYouSureToExit;
        Scanner sc = new Scanner(System.in);
        System.out.println("是否真的要離開了?(y/n):");
        areYouSureToExit = sc.nextLine();
        if (areYouSureToExit.equals("y") || areYouSureToExit.equals("Y")) {
            System.out.println("謝謝您的惠顧(❁´◡`❁) 歡迎下次再度蒞臨");
            return true;
        } else {
            System.out.println("將返回主畫面為您繼續服務");
            return false;
        }
    }

}