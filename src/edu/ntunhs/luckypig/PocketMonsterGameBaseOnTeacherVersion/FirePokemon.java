package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

import java.util.Random;

public class FirePokemon extends Pokemon {
    static String WetPokeInfo() {
        return "Fire Pokemon is a monster who is waiting water.";
    }

    int Attack(Pokemon enemyMonster) {
        Random rand1st = new Random(); // instance of random class
        int int_random = rand1st.nextInt(1);
        if (int_random == 0) {
            System.out.println("沒中 ");
        } else {
            enemyMonster.setHP(enemyMonster.getHP() - attack * 3);
        }
        if (enemyMonster.getHP() <= 0) {
            enemyMonster.setHP(0);
            System.out.println("OH" + enemyMonster.Name + " die!!");
            return 1;
        }
        return 0;
    }
}
