package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

public class Pokemon {
    abstract class abstractPokemon {
        int type = 1;// 寶可夢具有三種型態1、2、3
        // 1為初始型態、三為最終進化型態
        int level = 1;// 寶可夢具有等級，其上限為99等
        String attribute = "none";// 寶可夢具有6種屬性
        // none為無屬性、water為水屬性、fire為火屬性、wood為木屬性、light為光屬性、dark為暗屬性
        // 日後可以使用屬性來做相剋加減傷
        String name;
        int currentLocation;// 這隻寶可夢在地圖上的位置
        int HP, ATK, DEF, dodgeRate, agile;// 三圍數值、閃避率與敏捷度
        // 或許之後使用寶可夢的敏捷度來決定先攻順序
    }

    class PokemonNoneType extends abstractPokemon implements move, evolution {

        @Override
        public int evolutionToLV2(int currentLevel) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int evolutionToLV3(int currentLevel) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int run(int movement) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int fly(int movement) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

    interface move {
        int run(int movement);

        int fly(int movement);
    }

    interface evolution {
        int evolutionToLV2(int currentLevel);

        int evolutionToLV3(int currentLevel);
    }
}
