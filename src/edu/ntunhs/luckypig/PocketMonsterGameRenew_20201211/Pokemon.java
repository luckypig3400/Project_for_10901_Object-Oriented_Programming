package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

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
        int id;
        String name;
        int currentLocation;// 這隻寶可夢在地圖上的位置
        int HP, ATK, DEF, dodgeRate, agile;// 三圍數值、閃避率與敏捷度
        // 或許之後使用寶可夢的敏捷度來決定先攻順序
        boolean defendStatus = false;// 玩家選擇防禦後紀錄防禦狀態
    }

    public class PokemonNoneAttribute extends abstractPokemon {

        PokemonNoneAttribute() {
            HP = rnd.nextInt(300) + 600;
            attack = rnd.nextInt(66) + 100;
            defense = rnd.nextInt(30) + 90;
            avoidRate = 9;// default avoidRate = 9%
        }

        PokemonNoneAttribute(int in_ID, String in_Name) {
            ID = in_ID;
            Name = in_Name;
            HP = rnd.nextInt(300) + 600;
            attack = rnd.nextInt(66) + 100;
            defense = rnd.nextInt(30) + 90;
            avoidRate = 9;
        }

        PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF) {
            ID = in_ID;
            Name = in_Name;
            HP = in_HP;
            attack = in_ATK;
            defense = in_DEF;
            avoidRate = 9;// still use default avoid rate here
        }

        PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_avoidRate) {
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
