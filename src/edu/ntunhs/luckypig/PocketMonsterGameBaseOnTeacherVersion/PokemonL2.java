package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class PokemonL2 extends Pokemon {

    int oHP, oATK, oDEF, oAvoidRate;// o stand for original

    // 因為是用來進化的，所以應該只能透過有提供完整資料的建構子來進行
    // (不可以再像剛生成時使用亂數來賦予數值)

    PokemonL2(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
        ID = in_ID;
        Name = in_Name;
        oHP = in_HP;
        oATK = in_ATK;
        oDEF = in_DEF;
        oAvoidRate = in_avoidRate;
        evolution();
    }

    void evolution() {
        HP *= 1.2;
        attack *= 1.2;
        defense *= 1.2;
        avoidRate += 3;
    }

    void getEvolutionInfo() {
        System.out.println("【進化前】");
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + oHP + "\tATK:" + oATK + "\tDEF:" + oDEF
                + "\tavoidRate:" + oAvoidRate + "%");
        System.out.println("【進化後】");
        getPokemonInfo();
    }
}
