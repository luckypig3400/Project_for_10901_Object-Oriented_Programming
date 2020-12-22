package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

import java.util.Scanner;

public class Game {

    // TODO: use ArrayList to store players or pokemons
    // https://www.javatpoint.com/java-arraylist
    // TODO: create a class for File Saving (Maybe call it FileSavingjava)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("玩家1你好，請輸入你的帳號名稱:");
        String playeName = sc.nextLine();
        System.out.println("請設定密碼:");
        String password = sc.nextLine();
        Player p1 = new Player(1, playeName, password);

        System.out.println("玩家2你好，請輸入你的帳號名稱:");
        playeName = sc.nextLine();
        System.out.println("請設定密碼:");
        password = sc.nextLine();
        Player p2 = new Player(2, playeName, password);

        System.out.println("玩家1你好~歡迎來到這個神奇怪獸對打機遊戲，請輸入密碼登入:");
        password = sc.nextLine();
        while (p1.login(1, password) == 3) {
            System.out.println("密碼錯誤請重新輸入:");
            password = sc.nextLine();
        }
        if (p1.login(1, password) == 1)
            System.out.println("玩家1成功登入，熱烈歡迎" + p1.name + "來到這個神奇遊戲~");

        System.out.println("玩家2你好~歡迎來到這個神奇怪獸對打機遊戲，請輸入密碼登入:");
        password = sc.nextLine();
        while (p2.login(2, password) == 3) {
            System.out.println("密碼錯誤請重新輸入:");
            password = sc.nextLine();
        }
        if (p2.login(2, password) == 1)
            System.out.println("玩家2成功登入，熱烈歡迎" + p2.name + "來到這個神奇遊戲~");

        sc.close();
    }
}
