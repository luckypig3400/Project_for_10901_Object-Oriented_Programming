package edu.ntunhs.luckypig.javaMidtermExam;

public class Midterm_ATM_tester {

    public static void main(String[] args) {
        Midterm_ATM ATMtester1 = new Midterm_ATM();
        ATMtester1.login();
        ATMtester1.mainScreen();
        System.out.println("自動演示自動存入3000元");
        ATMtester1.deposit(false, 3000);
        System.out.println("自動演示自動提領3000元");
        ATMtester1.withdraw(false, 3000);

    }

}