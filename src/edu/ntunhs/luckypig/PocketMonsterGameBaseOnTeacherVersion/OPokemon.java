package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

abstract class OPokemon {
    String ID;
    String Name;
    int HP, attack, defense;
    int location;
    abstract int move(int movement);
    abstract int attack(OPokemon pada);
}
