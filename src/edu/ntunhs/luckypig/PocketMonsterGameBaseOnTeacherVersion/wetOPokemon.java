package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class wetOPokemon extends OPokemon{
    int waterLevel;

    wetOPokemon(){
        location = 0;
    }

    int move(int movement){
        return 0;
    }

    int attack(OPokemon pada){
        pada.HP -= attack;
        return 0;
    }

    @Override
    int attack(Pokemon pada) {
        pada.HP -= attack;
        return 0;
    }
}
