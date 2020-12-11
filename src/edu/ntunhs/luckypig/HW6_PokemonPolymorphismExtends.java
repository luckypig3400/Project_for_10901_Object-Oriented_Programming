package edu.ntunhs.luckypig;

import java.security.SecureRandom;
import java.util.Random;

public class HW6_PokemonPolymorphismExtends {
    public static void main(String[] args) {

        System.out.println("====================================");
        Pokemon myPoke = new Pokemon();
        System.out.println("使用Pokemon Class建立成功， 您的神奇寶貝為無屬性神奇寶貝，以下為其資訊:");
        myPoke.getPokemonInfo();

        System.out.println("====================================");
        Pokemon myPokeL2 = new PokemonL2(myPoke);
        System.out.println("使用PokemonL2 Class以多型方式進化成功， 您的神奇寶貝為無屬性神奇寶貝");
        System.out.println("成功進化後的寶可夢資訊:");
        myPokeL2.getPokemonInfo();

        System.out.println("====================================");
        Pokemon myPokeL3 = new PokemonL3_polymorphism(myPoke);
        System.out.println("使用PokemonL3_polymorphism Class進化成功， 您的神奇寶貝為無屬性神奇寶貝");
        System.out.println("已經成功進化到最終型態後的寶可夢資訊:");
        myPokeL3.getPokemonInfo();

    }
}

abstract class OPokemon {
    int ID;
    String Name;
    int HP, attack, defense;
    int location;
    Random rnd;
    RandomString randomStringGenerator;

    OPokemon() {
        rnd = new Random();
        ID = rnd.nextInt(999999999);

        String easy = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";
        randomStringGenerator = new RandomString(6, new SecureRandom(), easy);
        Name = randomStringGenerator.nextString();
    }

    void getPokemonInfo() {
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + HP + "\tATK:" + attack + "\tDEF:" + defense
                + "\nCurrent Location:" + location);
    }

    abstract int move(int movement);

    abstract int attack(Pokemon pada);
}

class Pokemon extends OPokemon {
    int Type;
    int Wallet;
    float Exp;
    int avoidRate;
    final int type = 1; // 0: Human, 1: Monster. 2: NPC

    Pokemon() {
        super();
        HP = rnd.nextInt(300) + 600;
        attack = rnd.nextInt(66) + 100;
        defense = rnd.nextInt(30) + 90;
        avoidRate = 9;// default avoidRate = 9%
    }

    Pokemon(int in_ID, String in_Name) {
        ID = in_ID;
        Name = in_Name;
        HP = rnd.nextInt(300) + 600;
        attack = rnd.nextInt(66) + 100;
        defense = rnd.nextInt(30) + 90;
        avoidRate = 9;
    }

    Pokemon(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF) {
        ID = in_ID;
        Name = in_Name;
        HP = in_HP;
        attack = in_ATK;
        defense = in_DEF;
        avoidRate = 9;// still use default avoid rate here
    }

    Pokemon(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
        ID = in_ID;
        Name = in_Name;
        HP = in_HP;
        attack = in_ATK;
        defense = in_DEF;
        avoidRate = in_avoidRate;// if set to 100 will become a super boss in game
    }

    static void getMap() {
        System.out.println("請看地圖:");
    }

    static void PokeInfo() {
        System.out.println("Pokemon is a monster, also called sweet potota~~");
    }

    int attack(Pokemon enemyMonster, boolean isTurble) {
        int result = 0;
        if (isTurble == true) {
            attack *= 2;
            result = attack(enemyMonster);
            attack /= 2;
        }
        return result;
    }

    @Override
    int attack(Pokemon enemyMonster) {
        Random rand1st = new Random(); // instance of random class
        int upperbound = 99;
        int int_random = rand1st.nextInt(upperbound);// get random int between 0 ~ 99
        // 第一次躲避
        if (int_random >= 0 && int_random < 50) {
            System.out.println("沒中 ");
            return 1;
        }
        // 第一次躲避失敗，攻擊
        else {
            Random rand2nd = new Random(); // instance of random class
            int_random = rand2nd.nextInt(upperbound);
            if (int_random >= 0 && int_random < 30) {
                // Do Nothing
                System.out.println("沒中 ");
            } else if (int_random > 30 && int_random < 50) {
                enemyMonster.setHP(enemyMonster.getHP() - attack * 2);
                System.out.println("Turbo");
            } else if (int_random > 50 && int_random < 60) {
                enemyMonster.setHP(enemyMonster.getHP() - attack / 2);
                System.out.println("so sad! only half");
            } else if (int_random > 60 && int_random < 100) {
                enemyMonster.setHP(enemyMonster.getHP() - attack);
                System.out.println("Normal!!");
            }
            if (enemyMonster.getHP() <= 0) {
                enemyMonster.setHP(0);
                System.out.println("OH" + enemyMonster.Name + " die!!");
                return 1;
            }
            return 0;
        }
    }

    int setDefenseProb(int prob) {
        return avoidRate = 50;
    }

    int Recovery() {
        return setHP(getHP() + 20);
    }

    public int getHP() {
        return HP;
    }

    public int setHP(int blood) {
        HP = blood;
        return blood;
    }

    @Override
    int move(int movement) {
        location += movement;
        return 0;
    }

    @Override
    void getPokemonInfo() {
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + HP + "\tATK:" + attack + "\tDEF:" + defense
                + "\tavoidRate:" + avoidRate + "%\nCurrent Location:" + location);
    }

}

class PokemonL2 extends Pokemon {

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

class PokemonL3_polymorphism extends Pokemon {

    int oHP, oATK, oDEF, oAvoidRate;// o stand for original

    // 因為是用來進化的，所以應該只能透過有提供完整資料的建構子來進行
    // (不可以再像剛生成時使用亂數來賦予數值)

    PokemonL3_polymorphism(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
        ID = in_ID;
        Name = in_Name;
        HP = oHP = in_HP;
        attack = oATK = in_ATK;
        defense = oDEF = in_DEF;
        avoidRate = oAvoidRate = in_avoidRate;
        evolutionToL2();
        evolutionToL3();
    }

    PokemonL3_polymorphism(Pokemon notEvolvedPokemon) {
        ID = notEvolvedPokemon.ID;
        Name = notEvolvedPokemon.Name;
        HP = oHP = notEvolvedPokemon.HP;
        // 如果希望HP = notEvolvedPokemon.HP; 同時 oHP = notEvolvedPokemon.HP;
        // 則應該寫成HP = oHP = notEvolvedPokemon.HP;
        // 若寫成HP = notEvolvedPokemon.HP = oHP;數值全部會變成0
        // 因為電腦是從最右邊的變數開始往前指派而oHP的初始值是0
        attack = oATK = notEvolvedPokemon.attack;
        defense = oDEF = notEvolvedPokemon.defense;
        avoidRate = oAvoidRate = notEvolvedPokemon.avoidRate;
        // System.out.println("Before evolution, defense:" + defense + "oDEF" + oDEF);
        evolutionToL2();
        evolutionToL3();
        // System.out.println("After evolution to L3, defense:" + defense + "oDEF" +
        // oDEF);
    }

    void evolutionToL2() {
        HP *= 1.2;
        attack *= 1.2;
        defense *= 1.2;
        avoidRate += 3;
    }

    void evolutionToL3() {
        HP *= 1.1;
        attack *= 1.1;
        defense *= 1.1;
        avoidRate += 9;// 最終型態的起始閃避率提升了不少
    }

    void getEvolutionInfo() {
        System.out.println("【進化前】");
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + oHP + "\tATK:" + oATK + "\tDEF:" + oDEF
                + "\tavoidRate:" + oAvoidRate + "%");
        System.out.println("【進化後】");
        getPokemonInfo();
    }

}
