package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

import java.util.Scanner;

public class testForOPokemon {

    public static void main(String[] args) {
        int movement;

        Scanner myScan = new Scanner(System.in);

        while (true) {
            System.out.println("請輸入移動步數 (輸入10000離開)");
            FlashPokemon Paka = new FlashPokemon();
            movement = myScan.nextInt();
            if (movement == 10000)
                break;
            System.out.println("現在位置" + Paka.move(movement));
            System.out.println("現在位置(Getter): " + Paka.getLocation());

        }
        myScan.close();
    }

}
