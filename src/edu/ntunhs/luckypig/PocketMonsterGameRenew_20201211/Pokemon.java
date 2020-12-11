package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

public class Pokemon {
    abstract class abstractPokemon {

    }

    class PokemonLV1 extends abstractPokemon {

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
