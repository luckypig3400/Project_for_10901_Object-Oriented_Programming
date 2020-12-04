package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

import java.util.Scanner;

public class teachersExampleCode {
    public static void main(String[] args) {
        NTUNHSpay myPay = new NTUNHSpay();
        Scanner myScan = new Scanner(System.in);
        int charge = 0, paymentOption = 1;
        while (true) {
            System.out.println("請輸入付款方式 1網銀 2信用卡(輸入0離開)");
            paymentOption = myScan.nextInt();
            if (paymentOption == 0)
                break;
            System.out.println("請輸入付款金額(輸入0離開)");
            charge = myScan.nextInt();
            if (charge == 0)
                break;
            if (myPay.payment(charge, paymentOption) == 1)
                System.out.println("餘額: " + Integer.toString(myPay.getBalance(paymentOption)));
            else
                System.out.println("付款失敗(*>﹏<*)可能原因:網銀餘額不足、信用額度不夠或是付款裝置感應不良");

        }
        myScan.close();
    }
}
