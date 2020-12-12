package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

public class Player {
    private int ID;
    private String PWD;
    String Name;
    int playerPokemonCount = 0;
    Pokemon[] pokemonInPlayerBag = new Pokemon[300];

    Player(int gID, String gPWD) {
        ID = gID;
        PWD = gPWD;
    }

    boolean setPWD(String oPWD, String gPWD) {
        if (oPWD.equals(PWD)) {
            PWD = gPWD;
            return true;
        } else
            return false;
    }

    String getName() {
        return Name;
    }

    void setName(String gName) {
        Name = gName;
    }

    int login(int gID, String gPWD) {
        if (gID != ID) {
            return 2; // 帳號錯誤
        }
        if (!PWD.equals(gPWD)) {
            return 3; // 密碼錯誤
        }
        return 1; // 登入成功
    }

    void addNewPokemonInPlayerBag(Pokemon newMonster) {
        pokemonInPlayerBag[playerPokemonCount] = newMonster;
        playerPokemonCount += 1;
    }
}