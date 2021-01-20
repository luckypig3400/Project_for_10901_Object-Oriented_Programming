package edu.ntunhs.luckypig.FinalExam20210108;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class finalExamExtnedTeacherExampleCode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("歡迎使用本系統~");
		User user1 = new User();
		//user1.printAllUserInfo();
		
		String inID, inPWD;
		System.out.println("請輸入帳號ID:");
		inID = sc.nextLine();
		System.out.println("請輸入帳號密碼:");
		inPWD = sc.nextLine();
		if(true == user1.login(inID, inPWD)) {
			user1.printHello();
		}
		
	}

}

class UserLog {
	private String logNo, logTime;
	private int tranType = 0; // paid by 0:XDPay, 1:NTUNHSPay
	private int money = 0, bonus = 0;

	UserLog(String inLogNo, int inTranType, int inMoney, int inBonus, String inLogTime) {
		logNo = inLogNo;
		tranType = inTranType;
		money = inMoney;
		bonus = inBonus;
		logTime = inLogTime;
	}

	String getLogString() {
		// 4.1.1回傳交易紀錄字串(含所有資訊)
		String fullLogString = logNo + "," + tranType + "," + money + "," + bonus + "," + logTime;
		return fullLogString;
	}

	public static String getCurrentlyDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(new Date());
	}
}

class User {
	private String name, ID, PWD;
	private boolean isLogged;
	private int bonus = 0, logCount = 0;
	private ArrayList<UserLog> myLogList;
	File profile = new File("Profile.txt");
	String logLines;

	User() {
		if (profile.exists()) {
			try {
				FileReader fReader = new FileReader(profile);
				BufferedReader bReader = new BufferedReader(fReader);

				name = bReader.readLine();
				ID = bReader.readLine();
				PWD = bReader.readLine();
				bonus = bReader.read();

				logLines += bReader.readLine();
				while (bReader.readLine() != "EOFException") {
					logLines += bReader.readLine();
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	void readProfile() {

	}

	// 3.1 & 3.2設計建構子並載入文字檔，將個人資料及交易紀錄匯入至物件中

	// logCount = myLogList.size();

	private void initial(String inName, String inID, String inPWD) {
		name = inName;
		ID = inID;
		PWD = inPWD;
		isLogged = false;
	}

	boolean login(String inID, String inPWD) {
		if (ID.equals(inID)) {
			if (PWD.equals(inPWD)) {
				isLogged = true;

				return true;
			} else {
				return false;// 輸入密碼錯誤(登入失敗)
			}
		} else {
			return false;// 輸入帳號錯誤(登入失敗)
		}
	}

	// 4.2儲值XDPay功能
	int deposit(int inMoney) {

		return -1;
	}

	// 4.3.1可選擇XDPay或CreditCardPay其中一種付款方式，用多型的方式實作兩種付款方式
	int withdraw(int payType, int inMoney) {
		return -1;
	}

	public ArrayList<UserLog> gerMyLogList() {
		return myLogList;
	}

	public void setMyLogList(ArrayList<UserLog> myLogList) {
		this.myLogList = myLogList;
	}

	public UserLog getLogByIndex(int index) {
		return myLogList.get(index);
	}
	
	public void printAllUserInfo() {
		System.out.println(name + "\t" + ID + "\t" + PWD + "\t" + bonus);
	}
	
	public void printHello(){
		System.out.println(" 歡迎光臨" + name);
	}
}

class Pay {
	int balance;

	Pay() {
		balance = 60000;
	}

	Pay(int inBalance) {
		balance = inBalance;
	}

	int withdraw(int gMonney) {

		return -1;
	}
}

interface PrepaidCard {
	boolean deposit(int gMoney);
}

class XDPay extends Pay implements PrepaidCard {
	// 1.儲值功能(請使用interface PrepaidCard實作)
	@Override
	public boolean deposit(int gMoney) {
		if (gMoney > 0) {
			balance += gMoney;
			return true;
		} else {
			return false;// 不可存入負數
		}
	}

	// 1.XDPay電子付款功能(請使用繼承類別Pay製作)
	@Override
	int withdraw(int gMoney) {
		if (gMoney > 0) {
			if (balance >= gMoney) {
				balance -= gMoney;
				return 1;// 餘額足夠，付款成功
			} else {
				return 0;// 餘額不足，付款失敗
			}
		} else {
			return -1;// 調皮搗蛋，不可輸入負數
		}
	}
}

class CreditCardsPay extends Pay {
	int creditLimit;// 一般的信用卡不具有餘額，只有信用額度

	public CreditCardsPay() {
		balance = 0;
		creditLimit = 30000;
	}

	// 1.信用卡付款功能(請使用繼承類別Pay製作)
	@Override
	int withdraw(int gMoney) {
		if (gMoney > 0) {
			if (creditLimit >= gMoney) {
				creditLimit -= gMoney;
				return 1;// 餘額足夠，付款成功
			} else {
				return 0;// 餘額不足，付款失敗
			}
		} else {
			return -1;// 調皮搗蛋，不可輸入負數
		}
	}
}

abstract class animal{
	animal(){
		
	}
	void run() {
		
	}
}
