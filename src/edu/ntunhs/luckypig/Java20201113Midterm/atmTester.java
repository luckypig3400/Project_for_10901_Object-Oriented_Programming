package edu.ntunhs.luckypig.Java20201113Midterm;

public class atmTester {
    public static void main(String[] args) throws InterruptedException {

        ATM myATM = new ATM();
        myATM.login();

        System.out.println("====================================");
        System.out.println("以下為加分題自動演示");
        System.out.println("====================================");
        System.out.println("自動登入:");
        Thread.sleep(600);
        myATM.login("082214226", "226");
        System.out.println("====================================");
        System.out.println("自動存款6000元:");
        Thread.sleep(600);
        myATM.deposit(6000);
        System.out.println("====================================");
        System.out.println("自動提款6000元:");
        Thread.sleep(600);
        myATM.withdraw(6000);
        System.out.println("====================================");
    }
}