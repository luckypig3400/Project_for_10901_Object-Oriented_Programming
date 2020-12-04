package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class FlashPokemon {
    int FlashLevel;
    int location;
    FlashPokemon(){
        this.location = 0;
    }

    int move(int movement){
        System.out.println("Before move:" + this.location);
        this.location += movement;
        System.out.println("After move:" + this.location);
        return this.location;
    }

    int attack(OPokemon pada){
        return 0;
    }

    int getLocation(){
        return this.location;
    }
}
