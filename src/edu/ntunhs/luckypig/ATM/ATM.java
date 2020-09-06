package edu.ntunhs.luckypig.ATM;
import java.util.Scanner;

public class ATM {
	final private static String account = "082214226";
	final private static String accountName = "楊曜承";
	final private static String password = "226";
	private int deposit = 50000;

	public static void main(String[] args) throws InterruptedException {
		Scanner functionSelect_in = new Scanner(System.in);//讓使用者選擇功能的Scanner
		Scanner password_in = new Scanner(System.in);//讓使用者輸入密碼的Scanner
		System.out.println("帳戶編號" + account + "您好，請輸入密碼:");
		if (password_in.nextLine().equals(password)) {// main screen
			/*
			password_in.close();
			不能在此處關閉Scanner物件
			否則後面再使用Scanner時會出現如下的Error
			Exception in thread "main" java.util.NoSuchElementException: No line found
			at java.base/java.util.Scanner.nextLine(Scanner.java:1651)
			at edu.ntunhs.luckypig.ATM.ATM.main(ATM.java:24)
			*/
			System.out.println("歡迎光臨" + accountName);
			Thread.sleep(1000);
			int functionSelection = -1;
			System.out.println("=========================================================");
			System.out.println("功能選項[1.查詢餘額]、[2.存款]、[3.提款]與 [4.離開] 請選擇:");
			while(functionSelection < 0){
				try {
					functionSelection = Integer.parseInt(functionSelect_in.nextLine());
					if(functionSelection > 0 && functionSelection < 5){//使用者輸入的數字必須為介於1~4之間的整數
						System.out.println("您選擇了功能"+functionSelection);

					}
					else{
						functionSelection = -1;
						System.out.println("功能選擇只能輸入數字1~4的其中一項,請重新選擇:");
					}
				} catch (Exception e) {
					functionSelection = -1;
					System.out.println("功能選擇只能輸入數字1~4的其中一項,請重新選擇:");
				}
			}

		} else {
			System.out.println("密碼錯誤將於三秒後離開...");
			System.out.println("3");
			Thread.sleep(1000);
			System.out.println("2");
			Thread.sleep(1000);
			System.out.println("1");
			Thread.sleep(1000);
			System.out.println("Good Bye~~");
		}

		password_in.close();
		functionSelect_in.close();//要關閉Scanner的話建議只在main結尾關閉

	}

}


