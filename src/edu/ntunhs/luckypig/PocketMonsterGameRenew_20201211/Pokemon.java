package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

import java.util.Random;

public class Pokemon {

    interface move { // maybe use it in the map system
        int run(int movement);

        int fly(int movement);
    }

    interface evolution {
        int evolutionToType2(int currentType);

        int evolutionToType3(int currentType);
    }

    abstract class abstractPokemon {
        int type = 1;// 寶可夢具有三種型態1、2、3
        // 1為初始型態、三為最終進化型態
        int level = 1;// 寶可夢具有等級，其上限為99等
        int exp = 0;// 使用經驗值來判斷寶可夢等級
        // 寶可夢被擊敗的話會掉落身上9%經驗值給對方但自身經驗不會減少
        String attribute = "none";// 寶可夢具有6種屬性
        // none為無屬性、water為水屬性、fire為火屬性、wood為木屬性、light為光屬性、dark為暗屬性
        // 日後可以使用屬性來做相剋加減傷
        int ID;
        String Name;
        int currentLocation;// 這隻寶可夢在地圖上的位置
        int HP, ATK, DEF, dodgeRate, agile;// 三圍數值、閃避率與敏捷度
        // 或許之後使用寶可夢的敏捷度來決定先攻順序
        boolean defendStatus = false;// 玩家選擇防禦後紀錄防禦狀態
    }

    public class PokemonNoneAttribute extends abstractPokemon {
        Random rnd = new Random();
        PokemonNoneAttribute() {
            HP = rnd.nextInt(300) + 600;
            ATK = rnd.nextInt(66) + 100;
            DEF = rnd.nextInt(30) + 90;
            dodgeRate = 9;// default dodgeRate = 9%
        }

        PokemonNoneAttribute(int in_ID, String in_Name) {
            ID = in_ID;
            Name = in_Name;
            HP = rnd.nextInt(300) + 600;
            ATK = rnd.nextInt(66) + 100;
            DEF = rnd.nextInt(30) + 90;
            dodgeRate = 9;
        }

        PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF) {
            ID = in_ID;
            Name = in_Name;
            HP = in_HP;
            ATK = in_ATK;
            DEF = in_DEF;
            dodgeRate = 9;// still use default avoid rate here
        }

        PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_dodgeRate) {
            ID = in_ID;
            Name = in_Name;
            HP = in_HP;
            ATK = in_ATK;
            DEF = in_DEF;
            dodgeRate = in_dodgeRate;// if set to 100 will become a super boss in game
        }

        static void getMap() {
            System.out.println("請看地圖:");
        }

        static void PokeInfo() {
            System.out.println("Pokemon is a monster, also called sweet potota~~");
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
            System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + HP + "\tATK:" + ATK + "\tDEF:" + DEF
                    + "\tdodgeRate:" + dodgeRate + "%\nCurrent Location:" + location);
        }

    }

    // class PokemonNoneAttribute extends abstractPokemon implements move, evolution
    // {

    // @Override
    // public int evolutionToType2(int currentLevel) {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // @Override
    // public int evolutionToType3(int currentLevel) {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // @Override
    // public int run(int movement) {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // @Override
    // public int fly(int movement) {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // }

}
