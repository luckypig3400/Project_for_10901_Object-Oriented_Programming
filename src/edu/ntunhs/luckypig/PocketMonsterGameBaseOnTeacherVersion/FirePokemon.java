package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

import java.util.Random;

public class FirePokemon extends Pokemon {
    static String WetPokeInfo() {
        return "Fire Pokemon is a monster who is waiting water.";
    }

    int Attack(Pokemon bada) {
        Random rand1st = new Random(); // instance of random class
        int int_random = rand1st.nextInt(1);
        if (int_random == 0) {
            System.out.println("沒中 ");
        } else {
            bada.setBlood(bada.getBlood() - Attack * 3);
        }
        if (bada.getBlood() <= 0) {
            bada.setBlood(0);
            System.out.println("OH" + bada.Name + " die!!");
            return 1;
        }
        return 0;
    }
}
