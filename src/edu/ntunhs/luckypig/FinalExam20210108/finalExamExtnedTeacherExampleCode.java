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
		System.out.println("�w��ϥΥ��t��~");
		User user1 = new User();
		//user1.printAllUserInfo();
		
		String inID, inPWD;
		System.out.println("�п�J�b��ID:");
		inID = sc.nextLine();
		System.out.println("�п�J�b���K�X:");
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
		// 4.1.1�^�ǥ�������r��(�t�Ҧ���T)
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
	
	public void printAllUserInfo() {
		System.out.println(name + "\t" + ID + "\t" + PWD + "\t" + bonus);
	}
	
	public void printHello(){
		System.out.println(" �w����{" + name);
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
	// 1.�x�ȥ\��(�Шϥ�interface PrepaidCard��@)
	@Override
	public boolean deposit(int gMoney) {
		if (gMoney > 0) {
			balance += gMoney;
			return true;
		} else {
			return false;// ���i�s�J�t��
		}
	}

	// 1.XDPay�q�l�I�ڥ\��(�Шϥ��~�����OPay�s�@)
	@Override
	int withdraw(int gMoney) {
		if (gMoney > 0) {
			if (balance >= gMoney) {
				balance -= gMoney;
				return 1;// �l�B�����A�I�ڦ��\
			} else {
				return 0;// �l�B�����A�I�ڥ���
			}
		} else {
			return -1;// �եַo�J�A���i��J�t��
		}
	}
}

class CreditCardsPay extends Pay {
	int creditLimit;// �@�몺�H�Υd���㦳�l�B�A�u���H���B��

	public CreditCardsPay() {
		balance = 0;
		creditLimit = 30000;
	}

	// 1.�H�Υd�I�ڥ\��(�Шϥ��~�����OPay�s�@)
	@Override
	int withdraw(int gMoney) {
		if (gMoney > 0) {
			if (creditLimit >= gMoney) {
				creditLimit -= gMoney;
				return 1;// �l�B�����A�I�ڦ��\
			} else {
				return 0;// �l�B�����A�I�ڥ���
			}
		} else {
			return -1;// �եַo�J�A���i��J�t��
		}
	}
}

abstract class animal{
	animal(){
		
	}
	void run() {
		
	}
}
