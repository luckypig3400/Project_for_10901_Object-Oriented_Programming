package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

import java.security.SecureRandom;
import java.util.Random;
import edu.ntunhs.luckypig.RandomString;

abstract class OPokemon {
    int ID;
    String Name;
    int HP, attack, defense;
    int location;
    Random rnd;
    RandomString randomStringGenerator;

    OPokemon() {
        rnd = new Random();
        ID = rnd.nextInt(999999999);

        String easy = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";
        randomStringGenerator = new RandomString(6, new SecureRandom(), easy);
        Name = randomStringGenerator.nextString();
    }

    void getPokemonInfo() {
        System.out.println("ID:" + ID + "\tName:" + Name + "\nHP:" + HP + "\tATK:" + attack + "\tDEF:" + defense
                + "\nCurrent Location:" + location);
    }

    abstract int move(int movement);

    abstract int attack(OPokemon pada);
}
