package edu.ntunhs.luckypig.PocketMonsterGame;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class PocketMonster {

    int blood, attack, defence;
    int avoidRate = 9;// 每隻寶可夢的預設迴避率均為9%
    float wallet, exp;
    String name;
	String ID;
	String type;
    // 寶可夢屬性包含:水water、火fire、木wooden、光light、暗dark
    int thisTurnSkill;
    boolean defenceStatus = false;

    PocketMonster() {
        Random setValueRandomMachine = new Random();
        blood = setValueRandomMachine.nextInt(300) + 900;// by default every monster will have at least 900 HP
        attack = setValueRandomMachine.nextInt(60) + 150;// by default every monster will have at least 150 ATK
        defence = setValueRandomMachine.nextInt(30) + 66;// by default every monster will have at least 66 DEF
        Date systemDate = new Date();
        name = systemDate.toString();// 未命名寶可夢則使用日期命名
    }

    PocketMonster(String in_name) {
        name = in_name;
        Random setValueRandomMachine = new Random();
        blood = setValueRandomMachine.nextInt(300) + 900;// by default every monster will have at least 900 HP
        attack = setValueRandomMachine.nextInt(60) + 150;// by default every monster will have at least 150 ATK
        defence = setValueRandomMachine.nextInt(30) + 66;// by default every monster will have at least 66 DEF
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
        System.out.print("迴避率:" + avoidRate + "% \n");
        System.out.print("屬性:" + type + "\t");
        System.out.print("金錢:" + wallet + "\t");
        System.out.print("EXP:" + exp + "\n");
        System.out.println("===========================");
    }

    void selectPocketMonsterSkill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請選擇" + name + "這回合要做的事\n1.攻擊(沒有被閃避成功發動攻擊時，有36%機率自身攻擊兩倍，11%機率自身攻擊減半，3%打出致命一擊(扣除對方當前血量的9/10))\n2.防禦(提升迴避率為30%並增加30%防禦值)\n3.回血(直接回復100點血量)\n請選擇:");
        String funString = sc.next();
        switch (funString) {
            case "1":// 攻擊
                thisTurnSkill = 1;
                break;
            case "2":// 防禦
                thisTurnSkill = 2;
                break;
            case "3":// 回血
                thisTurnSkill = 3;
                break;
            default:
                thisTurnSkill = -1;
                break;
        }
        sc.close();
    }

    void usePocketMonsterSkill(PocketMonster enemyMonster) {// 因為要讓雙邊玩家先選完要執行的動作才開始回合
        switch (thisTurnSkill) {
            case 1:// 攻擊
                Attack(enemyMonster);
                break;
            case 2:// 防禦
                Defense();
                break;
            case 3:// 回血
                Recover();
                break;
            default:
                // do nothing
                System.out.println(name + "的玩家輸入錯誤，作為懲罰這回合不能做任何事");
                break;
        }
    }

    void Attack(PocketMonster enemyMonster) {
        // 沒有被閃避成功發動攻擊時，有36%機率自身攻擊兩倍，11%機率自身攻擊減半，3%打出致命一擊(扣除對方當前血量的9/10)

        Random rnd = new Random();
        int randomNumber = rnd.nextInt(101);
        if (randomNumber > enemyMonster.avoidRate) {// 沒有被閃避，正常發動攻擊
            randomNumber = rnd.nextInt(101);
            if (randomNumber > 97) {// 致命一擊
                enemyMonster.blood -= enemyMonster.blood*9/10;// 無視防禦直接扣除敵方現有的9/10血量
                if (enemyMonster.blood > 0)
                    System.out.println(name + "全神貫注打出了致命一擊!!!!!!無視防禦直接扣除敵方現有的9/10血量!!!"
                            + enemyMonster.name + "的血量剩餘:" + enemyMonster.blood);
                else {
                    System.out.println(enemyMonster.name + "已經被" + name + "擊敗了!");
                    exp += enemyMonster.exp;// kill the enemy get EXP
                    System.out.println(name + "增加了" + exp + "點經驗");
                }
            } else if (randomNumber > 86) {// 攻擊力減半
                enemyMonster.blood -= (attack/2 - enemyMonster.defence);// 先扣除敵人防禦值再打
                if (enemyMonster.blood > 0)
                    System.out.println(name + "這回合虛弱造成攻擊力減半(*﹏*)對敵人造成了" + (attack/2 - enemyMonster.defence) + "點傷害\t"
                            + enemyMonster.name + "的血量剩餘:" + enemyMonster.blood);
                else {
                    System.out.println(enemyMonster.name + "已經被" + name + "擊敗了!");
                    exp += enemyMonster.exp;// kill the enemy get EXP
                    System.out.println(name + "增加了" + exp + "點經驗");
                }
            } else if (randomNumber > 50) {// 攻擊力兩倍
                enemyMonster.blood -= (2 * attack - enemyMonster.defence);// 先扣除敵人防禦值再打
                if (enemyMonster.blood > 0)
                    System.out.println(name + "這回合氣宇軒昂鬥志充沛造成攻擊力翻倍!對敵人造成了" + (2 * attack - enemyMonster.defence) + "點傷害\t"
                            + enemyMonster.name + "的血量剩餘:" + enemyMonster.blood);
                else {
                    System.out.println(enemyMonster.name + "已經被" + name + "擊敗了!");
                    exp += enemyMonster.exp;// kill the enemy get EXP
                    System.out.println(name + "增加了" + exp + "點經驗");
                }
            } else {// 普攻
                enemyMonster.blood -= (attack - enemyMonster.defence);// 先扣除敵人防禦值再打
                if (enemyMonster.blood > 0)
                    System.out.println(name + "發動了普通攻擊對敵人造成了" + (attack - enemyMonster.defence) + "點傷害\t"
                            + enemyMonster.name + "的血量剩餘:" + enemyMonster.blood);
                else {
                    System.out.println(enemyMonster.name + "已經被" + name + "擊敗了!");
                    exp += enemyMonster.exp;// kill the enemy get EXP
                    System.out.println(name + "增加了" + exp + "點經驗");
                }
            }

        } else{ // 被躲掉了
            System.out.println(name + "的攻擊被" + enemyMonster.name + "躲掉啦(*﹏*)");
        }
        
        enemyMonster.avoidRate = 9;//不管是否打中，重置敵人的閃避率為9%

    }

    void Defense() {// make pokemon's avoidRate = 30%
        avoidRate = 30;
        defence += defence * 0.3;
        System.out.println(name + "的迴避率提升至30%，並且防禦數值提升了30%");
        defenceStatus = true;
        // 為了確保公平性，防禦效果會等到被打後才消失
    }

    void Recover() {
        blood += 100;
        System.out.println(name + "的血量回復了100點");
    }

}
