package edu.ntunhs.luckypig.ATM;

import java.util.Scanner;

public class ATM {
	final private static String account = "082214226";
	final private static String accountName = "楊曜承";
	final private static String password = "226";
	private static int deposit = 50000;
	private static int dailyWithdrawAmount = 0;
	static Scanner functionSelect_in = new Scanner(System.in);// 讓使用者選擇功能的Scanner
	static Scanner password_in = new Scanner(System.in);// 讓使用者輸入密碼的Scanner
	static Scanner moneyInteger_in = new Scanner(System.in);// 讓使用者輸入金額的Scanner

	public static void main(String[] args) throws InterruptedException {
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
			int functionSelection = 0;// 功能選擇變數
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
								deposit(true, 0);
								functionSelection = 0;// return to main screen
								break;
							case 3:
								System.out.println("您選擇了功能" + functionSelection + ".提款");
								withdraw(true ,0);
								functionSelection = 0;// return to main screen
								break;
							case 4:
								System.out.println("您選擇了功能" + functionSelection + ".離開");
								System.out.println("請問您是否真的要離開了(y/n):");
								String shouldLeavingNow = functionSelect_in.nextLine();
								if (shouldLeavingNow.equals("y") || shouldLeavingNow.equals("Y"))
									functionSelection = 4;
								else if (shouldLeavingNow.equals("n") || shouldLeavingNow.equals("N"))
									functionSelection = 0;
								else {
									System.out.println("請不要調皮搗蛋~只能輸入y或n啦(可接受大寫或小寫)");
									functionSelection = 0;// return to main screen
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

	public static int deposit(boolean useBuiltInScanner, int depositMoneyIn) {
		int depositAmount = -1;
		while (depositAmount <= 0) {
			System.out.println("請您輸入要存款的金額(請輸入大於0的整數):");
			try {
				if (useBuiltInScanner == true)
					depositAmount = Integer.parseInt(moneyInteger_in.nextLine());
				else
					depositAmount = depositMoneyIn;
				// 如果不用函式內建的Scanner的話，直接讀取傳入函式的存款額，反之亦然

				if (depositAmount > 0) {
					// 感應器檢查紙鈔存放張數與真偽
					deposit += depositAmount;
					System.out.println("成功存入:" + depositAmount + "元");
					System.out.println("帳戶餘額:" + deposit + "元");
				}
			} catch (Exception e) {
				System.out.println("請不要輸入其他非數字的字元");
				depositAmount = -1;
			}
		}
		if (depositAmount > 0)
			return 1;// 存款成功回傳碼
		else
			return -1;// 存款失敗回傳碼
	}

	public static int withdraw(boolean useBuiltInScanner, int withdrawMoneyIn) throws InterruptedException {
		// 若要使用Thread.sleep()函式則需在後方加入throws InterruptedException
		int withdrawAmount = -1;
		while (withdrawAmount <= 0) {
			System.out.println("請您輸入要提款的金額(請輸入大於0的整數):");
			try {
				if (useBuiltInScanner == true)
					withdrawAmount = Integer.parseInt(moneyInteger_in.nextLine());
				else
					withdrawAmount = withdrawMoneyIn;
				// 如果不用函式內建的Scanner的話，直接讀取傳入函式的存款額，反之亦然

				if (withdrawAmount > 0) {
					System.out.println("即將要提領的金額為:" + withdrawAmount + "元");
					System.out.print("正在查詢帳戶餘額是否足夠");
					Thread.sleep(300);
					System.out.print(".");
					Thread.sleep(300);
					System.out.print(".");
					Thread.sleep(300);
					System.out.print(".");
					Thread.sleep(300);
					System.out.print(".");
					Thread.sleep(300);
					System.out.print(".");
					Thread.sleep(300);
					System.out.println(".");
					if (withdrawAmount < deposit) {// 檢查存款是否足夠
						System.out.println("餘額足夠(～￣▽￣)～");
						System.out.print("正在核對是否達今日提領上限");
						Thread.sleep(300);
						System.out.print(".");
						Thread.sleep(300);
						System.out.print(".");
						Thread.sleep(300);
						System.out.print(".");
						Thread.sleep(300);
						System.out.print(".");
						Thread.sleep(300);
						System.out.print(".");
						Thread.sleep(300);
						System.out.println(".");
						if (withdrawAmount + dailyWithdrawAmount <= 30000) {// 每日提領上限30000元
							System.out.println("請收好您的現金:" + withdrawAmount + "元");
							dailyWithdrawAmount += withdrawAmount;
							deposit -= withdrawAmount;
							// 感應器感測使用者是否取出現金了
							System.out.println("成功提領:" + withdrawAmount + "元");
							System.out.println("您今日提款剩餘額度:" + (30000 - dailyWithdrawAmount) + "元");
							Thread.sleep(600);
						} else {
							System.out.println("今日提款額度已達上限，請明日再來");
							// 今日提款額度已達上限，請明日再來
						}
					} else {
						System.out.println("存款不足!");
					}
				}
			} catch (Exception e) {
				System.out.println("請不要輸入其他非數字的字元");
				withdrawAmount = -1;
			}
		}
		if (withdrawAmount > 0)
			return deposit;// 存款成功回傳餘額
		else
			return -1;// 存款失敗回傳碼
	}

}

/*
 * 
 * 題目：設計一個自動提款機系統，功能以及配分比例說明(總分超過100分則以100分計算)如下：
 * 
 * 1.進入程式時提示使用者輸入密碼，當密碼正確時，進入功能選單；密碼錯誤，提示密碼錯誤並離開程式，帳號為學號，密碼為學號後三碼。登入成功後，畫面顯示「
 * 歡迎光臨 {姓名}」，其中{姓名}需顯示自己的姓名，預設餘額為50,000元 (10%) 2.
 * 進入[主畫面]後，印出功能選項[1.查詢餘額]、[2.存款]、[3.提款]與 [4.離開]，規格說明如下： 2.1. 按下數字[1]:
 * 查詢餘額，在畫面上顯示餘額，並跳回主畫面 (10%) 2.2. 按下數字[2]:
 * 存款，在畫面上顯示餘額，並提示使用者輸入存款金額，存款成功後，顯示餘額並跳回[主畫面] (10%) 2.2.1
 * 程式需判斷，輸入金額為非整數時，應提示使用者輸入錯誤，並提示停留在原本的功能，讓使用者能重新輸入 (5%) 2.2.2 將
 * [存款]功能使用函式的方式撰寫，規則如下 (15%)： - (1) 輸入變數: 1.存款金額、2.餘額。 - (2) 回傳結果:
 * 回傳狀態結果，資料型態自行設計，至少需包含以下狀態：(1)存款成功以及(2)存款失敗 2.3 按下數字[3]:
 * 提款，並提示使用者輸入提款金額，提款成功後，顯示餘額並跳回[主畫面] (10%) 2.3.1
 * 程式需判斷，輸入金額為非整數或是提款金額大於存款時，應提示使用者輸入錯誤，並提示停留在原本的功能，讓使用者能重新輸入 (10%) 2.3.2
 * 程式需判斷每日提款最大上限金額30,000元，當提款金額累計金額超過30,000元時應提示使用者無法提款，則回到上一個畫面，讓使用者能重新輸入。 (5%)
 * 2.3.3 將 [提款]功能使用函式的方式撰寫，規則如下(15%)： - 輸入變數: 1.提款金額、2.餘額。其中餘額需使用call by
 * value的方式傳遞變數值，並將提款後的結果使用return的方式回傳。 - 回傳結果: 若提款成功，則回傳餘額；若提款失敗，則回傳數值-1 2.4
 * 按下數字[4]: 離開，出現提示訊息，詢問是否離開，輸入小寫y或大寫Y則離開程式，若輸小寫n或大寫N則回到主畫面 (5%) 2.5
 * [主畫面]程式需判斷，輸入金額非1, 2, 3, 4，應提示使用者輸入錯誤，並提示停留在原本的功能，讓使用者能重新輸入選項 (5%)
 * 加分題：撰寫上述2.2.2以及2.3.3之測試程式 (15%)
 */