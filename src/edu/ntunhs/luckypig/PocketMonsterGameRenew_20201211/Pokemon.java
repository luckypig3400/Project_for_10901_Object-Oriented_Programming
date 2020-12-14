package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

public class Pokemon {
    abstract class abstractPokemon {

    }

    class PokemonNoneType extends abstractPokemon implements move , evolution{

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

    interface evolution{
        int evolutionToLV2(int currentLevel);
        int evolutionToLV3(int currentLevel);
    }
}
