package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class WetPokemon extends Pokemon {

    void singAsong() {
        System.out.println("helo, helo, helo how are you, I'm fine, I'm fine thank you!!");
    }

    static String WetPokeInfo() {
        return "wet Pokemon is a monster who is waiting fire.";
    }

    int Attack(Pokemon enemyMonster) {
        int enemyMonsterHP = enemyMonster.getHP() - Attack;
        enemyMonster.setHP(enemyMonsterHP);
        if (enemyMonster.getHP() <= 0) {
            enemyMonster.setHP(0);
            System.out.println("OH" + enemyMonster.Name + " die!!");
            return 1;
        }
        return 0;
    }

}
