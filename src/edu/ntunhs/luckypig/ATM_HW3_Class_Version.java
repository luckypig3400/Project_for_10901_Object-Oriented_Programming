package edu.ntunhs.luckypig;

import java.util.Scanner;

/**
 * ATM_HW3_Class_Version
 */
public class ATM_HW3_Class_Version {

	private final String accountNumber = "082214226";
	private final String accountName = "楊曜承";
	private final String accountPassword = "226";
	private int balance = 50000;
	private int dailyWithdrawAmount = 30000;
	private int functionSelection = 0;
	private boolean loginStatus = false;
	public Scanner userInputScanner = new Scanner(System.in);

	ATM_HW3_Class_Version() {

	}

	public void login() {
		System.out.println("您好~ 您的帳戶編號:" + accountNumber + "請輸入密碼:");
		if (userInputScanner.nextLine().equals(accountPassword)) {
			loginStatus = true;
		} else {
			loginStatus = false;
			System.out.println("密碼錯誤 即將離開程式");
		}
	}

	public void mainScreen() {
		if (loginStatus == true) {

			while (functionSelection == 0) {
				System.out.println("~~~~~~~~~~~~~~~ 歡迎光臨:" + accountName + "您好 ~~~~~~~~~~~~~~~");
				System.out.println("請在下方輸入數字選擇想使用的功能(1.查詢餘額 2.存款 3.提款 4.離開):");
				try {
					String functionSelectionString = "";
					functionSelectionString = userInputScanner.nextLine();
					functionSelection = Integer.parseInt(functionSelectionString);
					// 這樣做才不會因為Scanner.nextInt()的錯誤而造成無窮迴圈
				} catch (Exception e) {
					functionSelection = 0;// return to main page
					System.out.println("發現錯誤:" + e);// 提示系統維護員錯誤類型
					System.out.println("請您輸入數字而非其他字元!");
				}

				switch (functionSelection) {
					case 1:
						System.out.println("您的帳戶編號:" + accountNumber + "\t餘額剩餘:" + balance);
						functionSelection = 0;// return to main page
						break;

					case 2:
						deposit(true, 0);
						functionSelection = 0;// return to main page
						break;

					case 3:
						withdraw(true, 0);
						functionSelection = 0;// return to main page
						break;

					case 4:
						functionSelection = exit();
						break;

					default:
						functionSelection = 0;// return to main page
						System.out.println("請您輸入介於1~4之間的數字!");
						break;
				}

			}

		} else {
			// do nothing(exit the program)
		}

	}

	public int deposit(boolean useScannerToInputAmount, int depositAmount_in) {
		int depositAmount = 0;

		while (depositAmount <= 0) {

			if (useScannerToInputAmount == true) {
				System.out.println("您好請輸入要存入的金額(正整數):");
				try {
					String depositAmountString = "";
					depositAmountString = userInputScanner.nextLine();
					depositAmount = Integer.parseInt(depositAmountString);
					// 這樣做才不會因為Scanner.nextInt()的錯誤而造成無窮迴圈
				} catch (Exception e) {
					depositAmount = 0;// let user reinput the amount
					System.out.println("發現錯誤:" + e);
					System.out.println("請您輸入數字而非其他字元!");
				}
			} else
				depositAmount = depositAmount_in;

			if (depositAmount > 0) {
				System.out.println("正在進行存款...");
				balance += depositAmount;
				System.out.println("存款成功!");
				System.out.println("您的帳戶編號:" + accountNumber + "\t餘額剩餘:" + balance);
			} else {
				depositAmount = 0;
				System.out.println("請您輸入大於0的正整數!");
			}
		}

		if (depositAmount > 0)
			return depositAmount;// 存款成功
		else
			return 0;// 照理說不該看到這個回傳值

	}

	public int withdraw(boolean useScannerToInputAmount, int withdrawAmount_in) {
		int withdrawAmount = 0;

		while (withdrawAmount <= 0) {

			if (useScannerToInputAmount == true) {
				System.out.println("您好請輸入要提領的金額(正整數):");
				try {
					String withdrawAmountString = "";
					withdrawAmountString = userInputScanner.nextLine();
					withdrawAmount = Integer.parseInt(withdrawAmountString);
					// 這樣做才不會因為Scanner.nextInt()的錯誤而造成無窮迴圈
				} catch (Exception e) {
					withdrawAmount = 0;// let user reinput the amount
					System.out.println("發現錯誤:" + e);
					System.out.println("請您輸入數字而非其他字元!");
				}
			} else
				withdrawAmount = withdrawAmount_in;

			if (withdrawAmount > 0) {
				System.out.println("正在進行提款...");
				System.out.println("檢查餘額中...");
				if (balance >= withdrawAmount) {
					System.out.println("檢查每日提領上限中...");
					if (dailyWithdrawAmount - withdrawAmount >= 0) {
						balance -= withdrawAmount;
						dailyWithdrawAmount -= withdrawAmount;// 減少每日最大提領上限
						System.out.println("提款成功!");
						System.out.println(
								"您的帳戶編號:" + accountNumber + "\t餘額剩餘:" + balance + "\t今日提領上限剩餘:" + dailyWithdrawAmount);
					} else {
						System.out.println("超過日提領上限，請輸入更小的金額");
					}
				} else {
					System.out.println("帳戶餘額不足");
					break;// 餘額不足狀況應該直接回到主選單
				}

			} else {
				withdrawAmount = 0;
				System.out.println("請您輸入大於0的正整數!");
			}
		}

		if (withdrawAmount > 0)
			return withdrawAmount;// 存款成功
		else
			return 0;// 照理說不該看到這個回傳值

	}

	public int exit() {
		System.out.println("您真要離開了嗎(y/n)");
		String exitAnswer = userInputScanner.nextLine();
		if (exitAnswer.equals("y") || exitAnswer.equals("Y"))
			return 4;// return code for function status
		else if (exitAnswer.equals("n") || exitAnswer.equals("N"))
			return 0;// return code for function status
		else {
			System.out.println("只能輸入y或n喔(大小寫均可)");
			System.out.println("將返回主畫面");
			return 0;// return code for function status
		}
	}

}

/**
 * ATMTester
 */
class ATM_Tester{
    public static void main(String[] args) {
        ATM_HW3_Class_Version ATMtester1 = new ATM_HW3_Class_Version();
        ATMtester1.login();
        ATMtester1.mainScreen();
        System.out.println("自動演示自動存入3000元");
        ATMtester1.deposit(false, 3000);
        System.out.println("自動演示自動提領3000元");
        ATMtester1.withdraw(false, 3000);
    }
}