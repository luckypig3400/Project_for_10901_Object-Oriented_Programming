package edu.ntunhs.luckypig.ATM;

public class ATM_tester {
    public static void main(String[] args) throws InterruptedException {
        ATM atm = new ATM();
        atm.ATM_Main_Page();
        Thread.sleep(900);
        System.out.println("即將進入加分測試項目:");
        Thread.sleep(900);
        System.out.println("演示自動存入3000元......");
        atm.deposit(false, 3000);
        System.out.println("===========================================");
        Thread.sleep(900);
        System.out.println("演示自動提款3000元......");
        atm.withdraw(false, 3000);
    }
}
