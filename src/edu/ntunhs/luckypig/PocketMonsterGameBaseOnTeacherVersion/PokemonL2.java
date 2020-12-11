package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class PokemonL2 extends Pokemon {

    int oHP, oATK, oDEF, oAvoidRate;// o stand for original

    // 因為是用來進化的，所以應該只能透過有提供完整資料的建構子來進行
    // (不可以再像剛生成時使用亂數來賦予數值)

    PokemonL2(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
        ID = in_ID;
        Name = in_Name;
        HP = oHP = in_HP;
        // 如果希望HP = in_HP; 同時 oHP = in_HP;
        // 則應該寫成HP = oHP = in_HP;
        // 若寫成HP = in_HP = oHP;數值全部會變成0
        // 因為電腦是從最右邊的變數開始往前指派而oHP的初始值是0
        attack = oATK = in_ATK;
        defense = oDEF = in_DEF;
        avoidRate = oAvoidRate = in_avoidRate;
        // System.out.println("Before evolution, defense:" + defense + "oDEF" + oDEF);
        evolution();
        // System.out.println("After evolution, defense:" + defense + "oDEF" + oDEF);
    }

    PokemonL2(Pokemon notEvolvedPokemon) {
        ID = notEvolvedPokemon.ID;
        Name = notEvolvedPokemon.Name;
        HP = oHP = notEvolvedPokemon.HP;
        attack = oATK = notEvolvedPokemon.attack;
        defense = oDEF = notEvolvedPokemon.defense;
        avoidRate = oAvoidRate = notEvolvedPokemon.avoidRate;
        // System.out.println("Before evolution, defense:" + defense + "oDEF" + oDEF);
        evolution();
        // System.out.println("After evolution, defense:" + defense + "oDEF" + oDEF);
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
