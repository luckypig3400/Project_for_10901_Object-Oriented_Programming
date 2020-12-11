package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

/**
 * ClassClassify_20201211techer's Example
 */
public class ClassClassify_20201211techerExample {

}

class Monster {
    abstract class Pokemon {

    }

    class PokemonLV1 extends Pokemon {

    }

    class PokemonLV2 extends PokemonLV1 implements move {

    }

    interface move {
        int run(int movement);
        int fly(int movement);
    }
}