
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class finalExam {

	public static void main(String[] args) {

		System.out.println("歡迎使用本系統~");

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
		return "owo";
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

interface PrepaidCard{
	boolean deposit(int gMoney);
}

class XDPay{
	// 1.儲值功能(請使用interface PrepaidCard實作)
	int deposit(int gMoney) {
		return -1;
	}
	
	// 1.XDPay電子付款功能(請使用繼承類別Pay製作)
	int withdraw(int gMoney) {
		return -1;
	}
}

class CreditCardsPay{

	// 1.XDPay電子付款功能(請使用繼承類別Pay製作)
	int withdraw(int gMoney) {
		return -1;
	}
}