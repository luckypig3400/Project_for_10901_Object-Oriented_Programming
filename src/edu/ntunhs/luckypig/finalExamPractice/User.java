package edu.ntunhs.luckypig.finalExamPractice;

import java.io.*;
import java.util.ArrayList;

public class User {
    String id;
    String name;
    String password;
    int balance;
    int bonus;
    CreditCard creditCard1 = new CreditCard();
    boolean loginStatus;
    ArrayList<UserLog> myLogList = new ArrayList<UserLog>();
    File profile;

    User(File in_profile) {
        profile = in_profile;
        readProfile();
    }

    User(String in_id, String in_name, String in_password) {
        id = in_id;
        name = in_name;
        password = in_password;
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

    String login(String in_id, String in_pwd) {
        if (in_id.equals(id)) {
            if (in_pwd.equals(password)) {
                loginStatus = true;
                return "登入成功";
            } else {
                return "密碼錯誤";
            }
        } else {
            return "帳號錯誤";
        }
    }

    int readProfile() {
        boolean success = false;

        try {
            // 建議使用BufferedReader來讀取
            // https://www.stackchief.com/blog/FileReader%20vs%20BufferedReader%20vs%20Scanner%20%7C%20Java
            FileReader freader = new FileReader(profile);
            BufferedReader bReader = new BufferedReader(freader);
            final String headString = "id,name,password,balance,bonus,creditLimit,usedAmount,expiryDate";
            final String trCheckString = "# transactionRecord 1 line represent 1 record and the format is showing belowtransactionID,transactionType,transactionAmount,gainedBonus,transactionDate";
            String cache;
            cache = bReader.readLine();

            if (cache.equals(headString)) {
                // System.out.println("檔案位於:" + profile.getAbsolutePath());// debug用
                System.out.println("存檔欄位資訊正確 正在讀取存檔...");

                String line = bReader.readLine();
                String[] data = line.split(",");

                id = data[0];
                name = data[1];
                password = data[2];
                balance = Integer.parseInt(data[3]);
                bonus = Integer.parseInt(data[4]);

                creditCard1.creditLimit = Integer.parseInt(data[5]);
                creditCard1.usedAmount = Integer.parseInt(data[6]);
                creditCard1.expiryDate = data[7];

                // System.out.println("讀取出來的基本資訊如下:");// debug用 查看使用者資訊
                // System.out.println(getAllinfo());// debug用 查看使用者資訊
                System.out.println("成功讀取並載入使用者基本資訊");

                line = bReader.readLine();
                line += bReader.readLine();

                if (line.equals(trCheckString)) {
                    System.out.println("交易紀錄欄位資訊正確 正在讀取交易紀錄...");
                    // System.out.println("交易紀錄如下:");// debug用 查看單筆交易紀錄

                    String logFullString;
                    String[] logData;

                    while (bReader.ready()) {
                        logFullString = bReader.readLine();
                        logData = logFullString.split(",");

                        UserLog normalizedLog = new UserLog();// 每讀到一筆交易紀錄就必須建立新的物件
                        normalizedLog.transactionID = Integer.parseInt(logData[0]);
                        normalizedLog.transactionType = logData[1];
                        normalizedLog.transactionAmount = Integer.parseInt(logData[2]);
                        normalizedLog.gainedBonus = Integer.parseInt(logData[3]);
                        normalizedLog.transactionDate = logData[4];

                        myLogList.add(normalizedLog);

                        // System.out.println(normalizedLog.getFullLog());// debug用 查看單筆交易紀錄
                    }
                    success = true;
                    System.out.println("成功讀取" + myLogList.size() + "筆交易紀錄");

                    // 以下debug用
                    // System.out.println("讀取出來並存放在myLogList內的交易紀錄如下:");
                    // for (UserLog testLog : myLogList) {
                    // testLog.printFullLog();
                    // }

                } else {
                    System.out.println("交易紀錄欄位資訊有誤 存檔可能已毀損，請洽客服人員並回報以下資訊:");
                    System.out.println(profile.getAbsolutePath());
                }

            } else {
                System.out.println("存檔欄位資訊有誤 存檔可能已毀損，請洽客服人員並回報以下資訊:");
                System.out.println(profile.getAbsolutePath());
            }
            freader.close();

        } catch (Exception e) {
            System.out.println("檔案讀取中發生錯誤錯誤訊息如下:" + e);
            e.printStackTrace();// 輸出詳細錯誤資訊
            System.out.println("存檔可能已毀損，請洽客服人員並回報以上錯誤資訊");
        }

        if (success)
            return 0;
        else
            return -1;
    }

    int writeProfile() {
        // also create file at the same time(overwrite old profile)
        // maybe can write backup old profile in the future
        boolean success = false;
        File outputFile = new File(".\\profile.csv");
        final String headString = "id,name,password,balance,bonus,creditLimit,usedAmount,expiryDate";
        final String trCheckString = "# transactionRecord 1 line represent 1 record and the format is showing below\ntransactionID,transactionType,transactionAmount,gainedBonus,transactionDate";

        try {
            if (outputFile.exists()) {
                System.out.println("找到舊檔，將會覆寫存檔");
            } else {
                System.out.println("沒有舊檔，正在建立全新存檔...");
                if (outputFile.createNewFile()) {
                    System.out.println("成功建立存檔!");
                } else {
                    System.out.println("無法建立檔案!");
                }
            }

            FileWriter fWriter = new FileWriter(outputFile);
            BufferedWriter bWriter = new BufferedWriter(fWriter);

            System.out.println("正在寫入檔案檢驗資訊與使用者資料...");
            bWriter.write(headString);
            bWriter.newLine();
            bWriter.write(this.getAllinfo());
            bWriter.newLine();
            bWriter.write(trCheckString);
            bWriter.newLine();
            System.out.println("成功寫入檔案檢驗資訊與使用者資料!");

            System.out.println("正在逐行寫入交易資料...");
            int i = 0;
            while (i < this.myLogList.size()) {
                bWriter.write(this.myLogList.get(i).getFullLog());
                bWriter.newLine();
                i += 1;
            }
            System.out.println("成功寫入交易資料!");

            fWriter.close();
        } catch (Exception e) {
            System.out.println("存檔過程發生錯誤，存檔路徑為:" + outputFile.getAbsolutePath());
            System.out.println("詳細錯誤資訊如下:");
            e.printStackTrace();
        }

        if (success)
            return 0;
        else
            return -1;
    }

    String getAllinfo() {
        return id + "," + name + "," + password + "," + balance + "," + bonus + "," + creditCard1.getAllinfo();
    }

    void printAllinfo() {
        System.out.println(
                "帳號:" + id + "\n姓名:" + name + "\n密碼:" + password + "\n餘額:" + balance + "\n點數:" + bonus + "\n信用卡資訊:");
        creditCard1.printAllinfo();
    }

}