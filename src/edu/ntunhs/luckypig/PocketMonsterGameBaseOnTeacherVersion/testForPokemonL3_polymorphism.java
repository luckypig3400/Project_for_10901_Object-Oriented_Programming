package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class testForPokemonL3_polymorphism {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("角色建立成功， 您的第一個神奇寶貝為水系神奇寶貝\n");
        WetPokemon firstWetPokemon = new WetPokemon();
        System.out.println("WetPokemon's attack: " + firstWetPokemon.attack);
        firstWetPokemon.singAsong();

        System.out.println("====================================");
        Pokemon.getMap();// test static function
        Pokemon.PokeInfo();// test static function

        System.out.println("====================================");
        Pokemon myPoke = new Pokemon();
        System.out.println("使用Pokemon Class建立成功， 您的第二個神奇寶貝為無屬性神奇寶貝，以下為其資訊:");
        myPoke.getPokemonInfo();

        System.out.println("====================================");
        PokemonL2 myPokeL2 = new PokemonL2(myPoke.ID, myPoke.Name, myPoke.HP, myPoke.attack, myPoke.defense,
                myPoke.avoidRate);
        System.out.println("使用PokemonL2 Class進化成功， 您的第二個神奇寶貝為無屬性神奇寶貝，已經成功進化");
        myPokeL2.getEvolutionInfo();

        System.out.println("====================================");
        PokemonL3 myPokeL3 = new PokemonL3(myPokeL2.ID, myPokeL2.Name, myPokeL2.HP, myPokeL2.attack, myPokeL2.defense,
                myPokeL2.avoidRate);
        System.out.println("使用PokemonL3 Class進化成功， 您的第二個神奇寶貝為無屬性神奇寶貝，已經成功進化到最終型態");
        myPokeL3.getEvolutionInfo();

    }
}
