package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

public class Player {
    private int ID;
    private String PWD;
    String name;
    int playerPokemonCount = 0;
    Pokemon[] pokemonInPlayerBag = new Pokemon[300];

    Player(int in_ID, String in_name, String in_PWD) {
        ID = in_ID;
        name = in_name;
        PWD = in_PWD;
    }

    boolean setPWD(String oldPWD, String newPWD) {
        if (oldPWD.equals(PWD)) {
            PWD = newPWD;
            return true;
        } else
            return false;
    }

    String getName() {
        return name;
    }

    void setName(String gName) {
        name = gName;
    }

    void setPassword(String in_PWD) {
        PWD = in_PWD;
    }

    int changePassword(String originalPWD, String newPWD) {
        if (originalPWD.equals(PWD)) {
            PWD = newPWD;
            return 1;
        } else
            return 0;// failed password won't change
    }

    int login(int in_ID, String in_PWD) {
        if (in_ID != ID) {
            return 2; // 帳號錯誤
        }
        if (!PWD.equals(in_PWD)) {
            return 3; // 密碼錯誤
        }
        return 1; // 登入成功
    }

    void addNewPokemonInPlayerBag(Pokemon newMonster) {
        pokemonInPlayerBag[playerPokemonCount] = newMonster;
        playerPokemonCount += 1;
    }


    Pokemon selectPokemonToFight() {
        System.out.println("您共擁有" + playerPokemonCount + "隻寶可夢");
        for (int i = 0; i < pokemonInPlayerBag.length; i++) {
            System.out.println("您的第" + (i + 1) + "隻寶可夢訊息如下:");
            pokemonInPlayerBag[i].printPokemonInfo();
        }
    }
}