package edu.ntunhs.luckypig.PocketMonsterGame;

public class waterPocketMonster extends PocketMonster {

    public waterPocketMonster(String in_name,String in_id) {
        name = in_name;
        ID = in_id;
        attack = (int)(super.attack * 0.8);
        defence = (int)(super.attack * 1.8);
    }

}
