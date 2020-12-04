package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class PokemonL3 extends PokemonL2 {

    //因為是用來進化的，所以應該只能透過有提供完整資料的建構子來進行
    //(不可以再像剛生成時使用亂數來賦予數值)

    PokemonL3(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
        super(in_ID, in_Name, in_HP, in_ATK, in_DEF, in_avoidRate);
        ID = in_ID;
        Name = in_Name;
        oHP = in_HP;
        oATK = in_ATK;
        oDEF = in_DEF;
        oAvoidRate = in_avoidRate;
        evolution();
    }

    @Override
    void evolution() {
        HP *= 1.3;
        attack *= 1.3;
        defense *= 1.3;
        avoidRate += 9;//最終型態的起始閃避率提升了不少
    }

}
