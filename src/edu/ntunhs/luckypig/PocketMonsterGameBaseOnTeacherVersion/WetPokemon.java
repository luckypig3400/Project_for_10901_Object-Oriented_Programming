package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class WetPokemon extends Pokemon {

    void singAsong() {
        System.out.println("helo, helo, helo how are you, I'm fine, I'm fine thank you!!");
    }

    static String WetPokeInfo() {
        return "wet Pokemon is a monster who is waiting fire.";
    }

    int Attack(Pokemon enemyMonster) {
        int enemyMonsterBlood = enemyMonster.getBlood() - Attack;
        enemyMonster.setBlood(enemyMonsterBlood);
        if (enemyMonster.getBlood() <= 0) {
            enemyMonster.setBlood(0);
            System.out.println("OH" + enemyMonster.Name + " die!!");
            return 1;
        }
        return 0;
    }

}