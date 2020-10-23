package edu.ntunhs.luckypig.PocketMonsterGame;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class PocketMonster {

    int blood, attack, defence;
    int avoidRate = 30;// 每隻寶可夢的預設迴避率均為30%
    float wallet, exp;
    String name, ID, type;
    // 寶可夢屬性包含:水water、火fire、木wooden、光light、暗dark
    int thisTurnSkill;
    boolean defenceStatus = false;

    PocketMonster() {
        Random setValueRandomMachine = new Random();
        blood = setValueRandomMachine.nextInt(300) + 600;// by default every monster will have at least
        attack = setValueRandomMachine.nextInt(100) + 100;
        defence = setValueRandomMachine.nextInt(30) + 66;
        Date systemDate = new Date();
        name = systemDate.toString();// 未命名寶可夢則使用日期命名
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
        System.out.print("迴避率:" + avoidRate + "% \n");
        System.out.print("屬性:" + type + "\t");
        System.out.print("金錢:" + wallet + "\t");
        System.out.print("EXP:" + exp + "\n");
        System.out.println("===========================");
    }

    void selectPocketMonsterSkill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("請選擇" + name + "這回合要做的事\n1.攻擊()\n2.防禦(提升迴避率為50%並增加30%防禦值)\n3.回血(直接回復100點血量)\n請選擇:");
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
        // 20%機率自身攻擊兩倍，10%機率自身攻擊減半，40%機率攻擊力=attack

        Random rnd = new Random();
        if (rnd.nextInt(101) > enemyMonster.avoidRate)// 發動攻擊
            enemyMonster.blood -= (attack - enemyMonster.defence);// 先扣除敵人防禦值再打
        else // 被躲掉了
            System.out.println(name + "的攻擊被" + enemyMonster.name + "躲掉啦(*﹏*)");
        if (enemyMonster.blood <= 0)
            exp += enemyMonster.exp;// kill the enemy get EXP
        if (enemyMonster.blood > 0)
            System.out.println(name + "發動了普通攻擊\t" + enemyMonster.name + "的血量剩餘:" + enemyMonster.blood);
        else
            System.out.println(enemyMonster.name + "已經被" + name + "擊敗了!");
    }

    void Defense() {// make pokemon's avoidRate = 50%
        avoidRate = 50;
        defence += defence / 2;
        System.out.println(name + "的迴避率提升至50%，並且防禦數值提升了50%");
        defenceStatus = true;
        // 為了確保公平性，防禦效果會等到被打後才消失
    }

    void Recover() {
        blood += 100;
        System.out.println(name + "的血量回復了100點");
    }

}
