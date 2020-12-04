package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

import java.lang.System;
import java.util.Random;

public class Pokemon extends OPokemon {
    int Type;
    int Wallet;
    float Exp;
    int avoidRate;
    final int type = 1; // 0: Human, 1: Monster. 2: NPC

    Pokemon() {
        super();
        HP = rnd.nextInt(300) + 600;
        attack = rnd.nextInt(66) + 100;
        defense = rnd.nextInt(30) + 90;
        avoidRate = 9;// default avoidRate = 9%
    }

    Pokemon(int in_ID, String in_Name) {
        ID = in_ID;
        Name = in_Name;
        HP = rnd.nextInt(300) + 600;
        attack = rnd.nextInt(66) + 100;
        defense = rnd.nextInt(30) + 90;
        avoidRate = 9;
    }

    Pokemon(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF) {
        ID = in_ID;
        Name = in_Name;
        HP = in_HP;
        attack = in_ATK;
        defense = in_DEF;
        avoidRate = 9;// still use default avoid rate here
    }

    Pokemon(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
        ID = in_ID;
        Name = in_Name;
        HP = in_HP;
        attack = in_ATK;
        defense = in_DEF;
        avoidRate = in_avoidRate;// if set to 100 will become a super boss in game
    }

    static void getMap() {
        System.out.println("請看地圖:");
    }

    static void PokeInfo() {
        System.out.println("Pokemon is a monster, also called sweet potota~~");
    }

    int attack(Pokemon enemyMonster, boolean isTurble) {
        int result = 0;
        if (isTurble == true) {
            attack *= 2;
            result = attack(enemyMonster);
            attack /= 2;
        }
        return result;
    }

    @Override
    int attack(Pokemon enemyMonster) {
        Random rand1st = new Random(); // instance of random class
        int upperbound = 99;
        int int_random = rand1st.nextInt(upperbound);// get random int between 0 ~ 99
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
                enemyMonster.setHP(enemyMonster.getHP() - attack * 2);
                System.out.println("Turbo");
            } else if (int_random > 50 && int_random < 60) {
                enemyMonster.setHP(enemyMonster.getHP() - attack / 2);
                System.out.println("so sad! only half");
            } else if (int_random > 60 && int_random < 100) {
                enemyMonster.setHP(enemyMonster.getHP() - attack);
                System.out.println("Normal!!");
            }
            if (enemyMonster.getHP() <= 0) {
                enemyMonster.setHP(0);
                System.out.println("OH" + enemyMonster.Name + " die!!");
                return 1;
            }
            return 0;
        }
    }

    int setDefenseProb(int prob) {
        return avoidRate = 50;
    }

    int Recovery() {
        return setHP(getHP() + 20);
    }

    public int getHP() {
        return HP;
    }

    public int setHP(int blood) {
        HP = blood;
        return blood;
    }

    @Override
    int move(int movement) {
        location += movement;
        return 0;
    }

    @Override
    void getPokemonInfo() {
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + HP + "\tATK:" + attack + "\tDEF:" + defense
                + "\tavoidRate:" + avoidRate + "%\nCurrent Location:" + location);
    }

}
