package edu.ntunhs.luckypig.ATM;

import java.util.Scanner;

public class ATM {
	final private static String account = "082214226";
	final private static String accountName = "楊曜承";
	final private static String password = "226";
	private static int deposit = 50000;
	private static int dailyWithdrawAmount = 0;
	public static void main(String[] args) throws InterruptedException {
		Scanner functionSelect_in = new Scanner(System.in);// 讓使用者選擇功能的Scanner
		Scanner password_in = new Scanner(System.in);// 讓使用者輸入密碼的Scanner
		Scanner moneyInteger_in = new Scanner(System.in);// 讓使用者輸入金額的Scanner
		System.out.println("帳戶編號" + account + "您好，請輸入密碼:");
		if (password_in.nextLine().equals(password)) {// main screen
			/*
			 * password_in.close(); 不能在此處關閉Scanner物件 否則後面再使用Scanner時會出現如下的Error Exception in
			 * thread "main" java.util.NoSuchElementException: No line found at
			 * java.base/java.util.Scanner.nextLine(Scanner.java:1651) at
			 * edu.ntunhs.luckypig.ATM.ATM.main(ATM.java:24)
			 */
			System.out.println("歡迎光臨" + accountName);
			// 密碼正確，往下方進入主頁面
			int functionSelection = 0;//功能選擇變數
			while (functionSelection <= 0) {// 功能選擇頁面即為主畫面
				Thread.sleep(1000);
				System.out.println("=========================================================");
				System.out.println("功能選項[1.查詢餘額]、[2.存款]、[3.提款]與 [4.離開] 請選擇:");
				try {
					functionSelection = Integer.parseInt(functionSelect_in.nextLine());
					if (functionSelection > 0 && functionSelection < 5) {// 使用者輸入的數字必須為介於1~4之間的整數
						switch (functionSelection) {
							case 1:
								System.out.println("您選擇了功能" + functionSelection + ".查詢餘額");
								System.out.println("您的帳戶編號:" + account + "餘額剩餘:" + deposit);
								functionSelection = 0;// 歸零功能選擇變數，即可回到上層while迴圈繼續顯示主頁面
								break;
							case 2:
								System.out.println("您選擇了功能" + functionSelection + ".存款");

								break;
							case 3:
								System.out.println("您選擇了功能" + functionSelection + ".提款");
								break;
							case 4:
								System.out.println("您選擇了功能" + functionSelection + ".離開");
								System.out.println("請問您是否真的要離開了(y/n):");
								String shouldLeavingNow = functionSelect_in.nextLine();
								if(shouldLeavingNow.equals("y") || shouldLeavingNow.equals("Y"))functionSelection = 4;
								else if(shouldLeavingNow.equals("n") || shouldLeavingNow.equals("N"))functionSelection = 0;
								else{
									System.out.println("請不要調皮搗蛋~只能輸入y或n啦(可接受大寫或小寫)");
									functionSelection = 0;//return to main screen
								}
								break;
							default:
								System.out.println("??您選擇了功能??" + functionSelection + ".如果程序正常執行不應該看到此訊息");
								// 上方的if判斷式應當要攔截輸入非1~4的輸入數值
								break;
						}

					} else {
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
		functionSelect_in.close();
		moneyInteger_in.close();// 要關閉Scanner的話建議只在main結尾關閉

	}

}

/*
 * 
 * 題目：設計一個自動提款機系統，功能以及配分比例說明(總分超過100分則以100分計算)如下：
 * 
 * 1.
 * 進入程式時提示使用者輸入密碼，當密碼正確時，進入功能選單；密碼錯誤，提示密碼錯誤並離開程式，帳號為學號，密碼為學號後三碼。登入成功後，畫面顯示「歡迎光臨
 * {姓名}」，其中{姓名}需顯示自己的姓名，預設餘額為50,000元 (10%)
 * 
 * 2. 進入[主畫面]後，印出功能選項[1.查詢餘額]、[2.存款]、[3.提款]與 [4.離開]，規格說明如下：
 * 
 * 2.1. 按下數字[1]: 查詢餘額，在畫面上顯示餘額，並跳回主畫面 (10%)
 * 
 * 2.2. 按下數字[2]: 存款，在畫面上顯示餘額，並提示使用者輸入存款金額，存款成功後，顯示餘額並跳回[主畫面] (10%)
 * 
 * 2.2.1 程式需判斷，輸入金額為非整數時，應提示使用者輸入錯誤，並提示停留在原本的功能，讓使用者能重新輸入 (5%)
 * 
 * 2.2.2 將 [存款]功能使用函式的方式撰寫，規則如下 (15%)：
 * 
 * - (1) 輸入變數: 1.存款金額、2.餘額。
 * 
 * - (2) 回傳結果: 回傳狀態結果，資料型態自行設計，至少需包含以下狀態：(1)存款成功以及(2)存款失敗
 * 
 * 2.3 按下數字[3]: 提款，並提示使用者輸入提款金額，提款成功後，顯示餘額並跳回[主畫面] (10%)
 * 
 * 2.3.1 程式需判斷，輸入金額為非整數或是提款金額大於存款時，應提示使用者輸入錯誤，並提示停留在原本的功能，讓使用者能重新輸入 (10%)
 * 
 * 2.3.2
 * 程式需判斷每日提款最大上限金額30,000元，當提款金額累計金額超過30,000元時應提示使用者無法提款，則回到上一個畫面，讓使用者能重新輸入。 (5%)
 * 
 * 2.3.3 將 [提款]功能使用函式的方式撰寫，規則如下(15%)：
 * 
 * - 輸入變數: 1.提款金額、2.餘額。其中餘額需使用call by value的方式傳遞變數值，並將提款後的結果使用return的方式回傳。
 * 
 * - 回傳結果: 若提款成功，則回傳餘額；若提款失敗，則回傳數值-1
 * 
 * 2.4 按下數字[4]: 離開，出現提示訊息，詢問是否離開，輸入小寫y或大寫Y則離開程式，若輸小寫n或大寫N則回到主畫面 (5%)
 * 
 * 2.5 [主畫面]程式需判斷，輸入金額非1, 2, 3, 4，應提示使用者輸入錯誤，並提示停留在原本的功能，讓使用者能重新輸入選項 (5%)
 * 
 * 加分題：撰寫上述2.2.2以及2.3.3之測試程式 (15%)
 */