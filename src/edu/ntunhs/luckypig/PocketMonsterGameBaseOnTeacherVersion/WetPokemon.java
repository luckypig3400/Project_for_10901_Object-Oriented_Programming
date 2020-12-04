package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class WetPokemon extends Pokemon {

    void singAsong() {
        System.out.println("helo, helo, helo how are you, I'm fine, I'm fine thank you!!");
    }

    static String WetPokeInfo() {
        return "wet Pokemon is a monster who is waiting fire.";
    }

    int Attack(Pokemon bada) {
        int badaBlood = bada.getBlood() - Attack;
        bada.setBlood(badaBlood);
        if (bada.getBlood() <= 0) {
            bada.setBlood(0);
            System.out.println("OH" + bada.Name + " die!!");
            return 1;
        }
        return 0;
    }

}
