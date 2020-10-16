package edu.ntunhs.luckypig.PocketMonsterGame;

import java.util.Date;
import java.util.Random;

public class PocketMonster {

    int blood, attack, defence;
    float wallet, exp, avoidRate;
    String name, ID, type;
    // 寶可夢屬性包含:水water、火fire、木wooden、光light、暗dark

    PocketMonster() {
        Random setValueRandomMachine = new Random();
        blood = setValueRandomMachine.nextInt(300) + 600;// by default every monster will have at least
        attack = setValueRandomMachine.nextInt(100) + 100;
        defence = setValueRandomMachine.nextInt(30) + 66;
        Date systemDate = new Date();
        name = systemDate.toString();
    }

    PocketMonster(String in_name) {
        name = in_name;
        Random setValueRandomMachine = new Random();
        blood = setValueRandomMachine.nextInt(300) + 600;// by default every monster will have at least 600 HP
        attack = setValueRandomMachine.nextInt(100) + 100;
        defence = setValueRandomMachine.nextInt(30) + 66;
    }

    PocketMonster(String in_name, int in_hp, int in_atk, int in_def, String in_type, float in_wallet, float in_exp) {
        name = in_name;
        blood = in_hp;
        attack = in_atk;
        defence = in_def;
        type = in_type;
        wallet = in_wallet;
        exp = in_exp;
    }

    void getPocketMonsterInfo() {
        System.out.println("===========================");
        System.out.println("您的寶可夢:" + name);
        System.out.print("ID :" + ID + "\t");
        System.out.print("HP :" + blood + "\t");
        System.out.print("ATK:" + attack + "\t");
        System.out.print("DEF:" + defence + "\t");
        System.out.print("迴避率:" + avoidRate + "\n");
        System.out.print("屬性:" + type + "\t");
        System.out.print("金錢:" + wallet + "\t");
        System.out.print("EXP:" + exp + "\n");
        System.out.println("===========================");
    }

    int Attack(PocketMonster enemyMonster) {
        enemyMonster.blood -= (attack - enemyMonster.defence);// 先扣除敵人防禦值再打
        if (enemyMonster.blood <= 0)
            exp += enemyMonster.exp;// kill the enemy get EXP
        if(enemyMonster.blood > 0)System.out.println(enemyMonster.name + "的血量剩餘:" + enemyMonster.blood);
        else System.out.println(enemyMonster.name + "已經被" + name + "擊敗了!");
        return 0;
    }



}
