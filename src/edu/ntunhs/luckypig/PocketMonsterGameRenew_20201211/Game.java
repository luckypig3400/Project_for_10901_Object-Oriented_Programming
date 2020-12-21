package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

public class Game {

    // TODO: use ArrayList to store players or pokemons
    // https://www.javatpoint.com/java-arraylist
    // TODO: create a class for File Saving (Maybe call it FileSavingjava)

    public static void main(String[] args) {
        Player p1 = new Player(1, "玩家1", "1");
        Player p2 = new Player(2, "玩家2", "2");

        Pokemon.PokemonNoneAttribute testPoke1 = new Pokemon().new PokemonNoneAttribute();
        testPoke1.printPokemonInfo();
    }
}
