package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

/**
 * ClassClassify_20201211techer's Example 運用到Nested Class的概念來整理寶可夢類別
 */
public class ClassClassify_20201211techerExample {

}

class Monster {// 寶可夢大類別(包含進化後的類別、五屬性寶可夢類別、以及interface)
    abstract class Pokemon {
        int currentLocationX = 0;
        int currentLocationY = 0;
    }

    class PokemonLV1 extends Pokemon {

    }

    class PokemonLV2 extends PokemonLV1 implements move {

        @Override
        public int run(int movementX, int movementY) {
            currentLocationX += movementX;
            currentLocationY += movementY;
            return 0;
        }

        @Override
        public int fly(int movementX, int movementY) {
            currentLocationX += movementX * 3;
            currentLocationY += movementY * 3;
            return 0;
        }

    }

    interface move {
        int run(int movementX, int movementY);

        int fly(int movementX, int movementY);
    }
}

class FightSystem {
    Pokemon fighter1;
    Pokemon fighter2;

    void menu() {

    }

    void attack(Pokemon attacker, Pokemon defender) {

    }

    void defend(Pokemon defender) {

    }

    void selectPokemon(Player player1, Player player2) {

    }
}