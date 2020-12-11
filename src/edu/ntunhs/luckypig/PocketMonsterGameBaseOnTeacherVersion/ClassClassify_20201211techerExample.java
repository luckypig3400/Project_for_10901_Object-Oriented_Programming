package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

/**
 * ClassClassify_20201211techer's Example
 * 運用到Nested Class的概念來整理寶可夢類別
 */
public class ClassClassify_20201211techerExample {

}

class Monster {//寶可夢大類別(包含進化後的類別、五屬性寶可夢類別、以及interface)
    abstract class Pokemon {

    }

    class PokemonLV1 extends Pokemon {

    }

    class PokemonLV2 extends PokemonLV1 implements move {

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
}

class Fight{
    class menu{

    }

    class attack{

    }

    class defend{

    }

    class selectPokemon{

    }
}