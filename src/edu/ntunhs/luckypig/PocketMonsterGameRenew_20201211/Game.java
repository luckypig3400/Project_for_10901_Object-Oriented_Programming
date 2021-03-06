package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

import java.util.Scanner;

public class Game {

    // TODO: use ArrayList to store players or pokemons
    // https://www.javatpoint.com/java-arraylist
    // TODO: create a class for File Saving (Maybe call it FileSavingjava)

    public static void main(String[] args) throws InterruptedException {
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

        System.out.println(p1.name + "快來幫你的第一隻寶可夢取個名字吧:");
        String pokeName = sc.nextLine();
        Pokemon.PokemonNoneAttribute p1FirstPoke = new Pokemon().new PokemonNoneAttribute(1, pokeName);
        p1.addNewPokemonInPlayerBag(p1FirstPoke);

        System.out.println(p2.name + "快來幫你的第一隻寶可夢取個名字吧:");
        pokeName = sc.nextLine();
        Pokemon.PokemonNoneAttribute p2FirstPoke = new Pokemon().new PokemonNoneAttribute(1, pokeName);
        p2.addNewPokemonInPlayerBag(p2FirstPoke);

        p1.printAllPokemonInfos();
        System.out.println("您有3秒時間閱讀以上資訊...");
        Thread.sleep(3000);
        p2.printAllPokemonInfos();
        System.out.println("您有3秒時間閱讀以上資訊...");
        Thread.sleep(3000);

        Pokemon fighter1;
        Pokemon fighter2;
        System.out.println("請" + p1.name + "選擇一隻要用來對戰的寶可夢，輸入是背包內第幾隻即可(整數):");
        int serialNumberInBag = sc.nextInt();
        fighter1 = p1.selectPokemonToFight(serialNumberInBag);
        System.out.println("請" + p2.name + "選擇一隻要用來對戰的寶可夢，輸入是背包內第幾隻即可(整數):");
        serialNumberInBag = sc.nextInt();
        fighter2 = p2.selectPokemonToFight(serialNumberInBag);

        // TODO : put fighters in fight system and complete fight system

        sc.close();
    }
}
