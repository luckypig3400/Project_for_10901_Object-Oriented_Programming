package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class PokemonL3 extends PokemonL2 {

    PokemonL3() {
        super();
    }

    PokemonL3(int in_ID, String in_Name) {
        super(in_ID, in_Name);
    }

    @Override
    void evolution() {
        HP *= 1.2;
        attack *= 1.2;
        defense *= 1.2;
        avoidRate += 9;//最終型態的起始閃避率提升了不少
    }
    
}
