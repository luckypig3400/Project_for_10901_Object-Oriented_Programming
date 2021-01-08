package edu.ntunhs.luckypig;

import java.io.File;
import java.util.Scanner;

public class fileReadWritePractive {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        File file1 = new File("test.txt");
        if (file1.exists()) {
            System.out.println(file1.getName() + "存在於以下路徑:" + file1.getAbsolutePath());

            //TODO 練習讀取與寫入檔案

        } else {
            System.out.println(file1.getName() + "不存在，是否需要為您建立預設檔案?(y/n):");

            if (inputScanner.nextLine().equals("y")) {
                try {
                    System.out.println("成功建立檔案，存在於以下路徑:" + file1.getAbsolutePath());
                } catch (Exception e) {
                    System.out.println(file1.getName() + "已經存在或因為其他原因無法新增");
                    System.out.println("如需更多幫助，請將以下錯誤訊息傳送給工程人員:\n" + e);
                }
            } else {
                System.out.println("好的 不會建立預設檔案");
                System.out.println("由於沒有存檔，將自動離開系統...");
            }
        }

        inputScanner.close();
    }
}
