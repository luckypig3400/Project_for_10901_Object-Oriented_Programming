package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class PokemonL2 extends Pokemon {

    int oHP, oATK, oDEF, oAvoidRate;// o stand for original

    PokemonL2() {
        super();
        oHP = HP;
        oATK = attack;
        oDEF = defense;
        oAvoidRate = avoidRate;
        evolution();
    }

    PokemonL2(int in_ID, String in_Name) {
        super(in_ID, in_Name);
        oHP = HP;
        oATK = attack;
        oDEF = defense;
        oAvoidRate = avoidRate;
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
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + oHP + "\tATK:" + oATK + "\tDEF:" + oDEF);
        System.out.println("【進化後】");
        getPokemonInfo();
    }
}
