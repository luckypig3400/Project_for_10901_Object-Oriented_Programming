package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

import java.lang.System;
import java.util.Random;

public class Pokemon {
    int ID;
    private int Blood = 100;
    int Attack = 100;
    int Defence;
    String Name;
    int Type;
    int Wallet;
    float Exp;
    int AvoidRate;
    final int type = 1; // 0: Human, 1: Monster. 2: NPC

    Pokemon() {
        System.out.println("Hello World 畜生");
        setBlood(100);
        Attack = 100;
        Defence = 100;
    }

    Pokemon(int gID, String gName) {
        ID = gID;
        Name = gName;
        setBlood(100);
        Attack = 100;
        Defence = 100;
        AvoidRate = 100;
    }

    static void getMap() {
        System.out.println("請看地圖 ");
    }

    static void PokeInfo() {
        System.out.println("Pokemon is a monster, also called sweet potota~~");
    }

    int Attack(Pokemon enemyMonster, boolean isTurble) {
        int result = 0;
        if (isTurble == true) {
            Attack *= 2;
            result = Attack(enemyMonster);
            Attack /= 2;
        }
        return result;
    }

    int Attack(Pokemon enemyMonster) {
        Random rand1st = new Random(); // instance of random class
        int upperbound = 99;
        int int_random = rand1st.nextInt(upperbound);//get random int between 0 ~ 99
        // 第一次躲避
        if (int_random >= 0 && int_random < 50) {
            System.out.println("沒中 ");
            return 1;
        }
        // 第一次躲避失敗，攻擊
        else {
            Random rand2nd = new Random(); // instance of random class
            int_random = rand2nd.nextInt(upperbound);
            if (int_random >= 0 && int_random < 30) {
                // Do Nothing
                System.out.println("沒中 ");
            } else if (int_random > 30 && int_random < 50) {
                enemyMonster.setBlood(enemyMonster.getBlood() - Attack * 2);
                System.out.println("Turbo");
            } else if (int_random > 50 && int_random < 60) {
                enemyMonster.setBlood(enemyMonster.getBlood() - Attack / 2);
                System.out.println("so sad! only half");
            } else if (int_random > 60 && int_random < 100) {
                enemyMonster.setBlood(enemyMonster.getBlood() - Attack);
                System.out.println("Normal!!");
            }
            if (enemyMonster.getBlood() <= 0) {
                enemyMonster.setBlood(0);
                System.out.println("OH" + enemyMonster.Name + " die!!");
                return 1;
            }
            return 0;
        }
    }

    int setDefenseProb(int prob) {
        return AvoidRate = 50;
    }

    int Recovery() {
        return setBlood(getBlood() + 20);
    }

    public int getBlood() {
        return Blood;
    }

    public int setBlood(int blood) {
        Blood = blood;
        return blood;
    }
}
