package edu.ntunhs.luckypig.PocketMonsterGame;

public class waterPocketMonster extends PocketMonster {

    waterPocketMonster(){
        super();
    }

    waterPocketMonster(String in_name,String in_id) {
        name = in_name;
        ID = in_id;
        attack = (int)(super.attack * 0.8);
        defence = (int)(super.attack * 1.8);
    }

    //水屬性寶可夢攻擊命中率100%

    static void singAsong() {
        // 水系寶可夢具有唱歌的技能，而且就算沒有水系寶可夢，仍然可以使用此技能
        // (加上static可以讓該function或變數在沒有宣告物件時仍可以被呼叫)
        System.out.println("Hello hello ~  How are you ,I'm fine I'm fine I'm fine. Thank you ~~~");
    }

}
