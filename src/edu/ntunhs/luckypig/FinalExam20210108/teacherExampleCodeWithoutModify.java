
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class finalExam {

	public static void main(String[] args) {

		System.out.println("�w��ϥΥ��t��~");

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
		// 4.1.1�^�ǥ�������r��(�t�Ҧ���T)
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

	// 3.1 & 3.2�]�p�غc�l�ø��J��r�ɡA�N�ӤH��ƤΥ�������פJ�ܪ���

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
				return false;// ��J�K�X���~(�n�J����)
			}
		} else {
			return false;// ��J�b�����~(�n�J����)
		}
	}

	// 4.2�x��XDPay�\��
	int deposit(int inMoney) {

		return -1;
	}

	// 4.3.1�i���XDPay��CreditCardPay�䤤�@�إI�ڤ覡�A�Φh�����覡��@��إI�ڤ覡
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
	// 1.�x�ȥ\��(�Шϥ�interface PrepaidCard��@)
	int deposit(int gMoney) {
		return -1;
	}
	
	// 1.XDPay�q�l�I�ڥ\��(�Шϥ��~�����OPay�s�@)
	int withdraw(int gMoney) {
		return -1;
	}
}

class CreditCardsPay{

	// 1.XDPay�q�l�I�ڥ\��(�Шϥ��~�����OPay�s�@)
	int withdraw(int gMoney) {
		return -1;
	}
}