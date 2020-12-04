package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

import java.util.Scanner;

public class teachersExampleCode {
    public static void main(String[] args) {
        NTUNHSpay myPay = new NTUNHSpay();
        Scanner myScan = new Scanner(System.in);
        int charge = 0;
        while (true) {
            System.out.println("請輸入付款金額(輸入0離開)");
            charge = myScan.nextInt();
            if (charge == 0)
                break;
            myPay.payment(charge);
            System.out.println("餘額: " + Integer.toString(myPay.getBalance()));
        }
        myScan.close();
    }
}
