package edu.ntunhs.luckypig.PocketMonsterGame;

import java.util.Random;

public class monsterGame {
    public static void main(String[] args) throws InterruptedException {

        PocketMonster PikaChu = new PocketMonster("PikaChu");
        PocketMonster turtle = new PocketMonster("傑尼龜");
        
        System.out.println("玩家1的精靈為"+PikaChu.name+"精靈屬性:");
        PikaChu.getPocketMonsterInfo();
        Thread.sleep(900);

        System.out.println("玩家2的精靈為"+PikaChu.name+"精靈屬性:");
        turtle.getPocketMonsterInfo();
        Thread.sleep(900);

        int roundCount = 1;

        while(true){//對戰擂台正式開始~~~
            
            System.out.println("======第"+roundCount+"回合開始======");
            Thread.sleep(300);

            System.out.println("請玩家1選擇精靈這回合要做的動作");
            PikaChu.selectPocketMonsterSkill();//玩家1
            Thread.sleep(600);

            System.out.println("請玩家2選擇精靈這回合要做的動作");
            turtle.selectPocketMonsterSkill();//玩家2
            Thread.sleep(600);

            System.out.println("正在隨機抽取誰優先行動");
            Thread.sleep(600);
            Random rnd = new Random();
            int whoGoFirst = rnd.nextInt(2);
            if(whoGoFirst == 0){
                System.out.println("由"+PikaChu.name+"先行動:");
                PikaChu.usePocketMonsterSkill(turtle);
                Thread.sleep(900);
            }else{
                System.out.println("由"+turtle.name+"先行動:");
                turtle.usePocketMonsterSkill(PikaChu);
                Thread.sleep(900);
            }
            
            if(PikaChu.blood <= 0 || turtle.blood <= 0) break;//break判斷寫在中間可以防止死亡的Pokemon多打一次 by 柏勳
            
            if(whoGoFirst == 0){
                System.out.println("接著由"+turtle.name+"行動:");
                turtle.usePocketMonsterSkill(PikaChu);
                Thread.sleep(900);
            }else{
                System.out.println("接著由"+PikaChu.name+"行動:");
                PikaChu.usePocketMonsterSkill(turtle);
                Thread.sleep(900);
            }
            
            if(PikaChu.blood <= 0 || turtle.blood <= 0) break;//雙方都攻擊後再次確認雙方血量

            System.out.println("======第"+roundCount+"回合結束======\n\n\n");
            roundCount += 1;
            Thread.sleep(600);
        }

    }
}
