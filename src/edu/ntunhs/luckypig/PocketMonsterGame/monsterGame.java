package edu.ntunhs.luckypig.PocketMonsterGame;

public class monsterGame {
    public static void main(String[] args) throws InterruptedException {
        PocketMonster PikaChu = new PocketMonster("PikaChu");
        PocketMonster turtle = new PocketMonster("傑尼龜");

        PikaChu.getPocketMonsterInfo();
        turtle.getPocketMonsterInfo();

        while(true){
            PikaChu.Attack(turtle);
            Thread.sleep(300);
            if(PikaChu.blood <= 0 || turtle.blood <= 0) break;
            //break判斷寫在中間可以防止死亡的Pokemon多打一次 by 柏勳
            turtle.Attack(PikaChu);
            Thread.sleep(300);
        }

    }
}
