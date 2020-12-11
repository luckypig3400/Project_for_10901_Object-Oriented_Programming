package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class testForPokemonL3_polymorphism {
    public static void main(String[] args) {

        System.out.println("====================================");
        Pokemon myPoke = new Pokemon();
        System.out.println("使用Pokemon Class建立成功， 您的神奇寶貝為無屬性神奇寶貝，以下為其資訊:");
        myPoke.getPokemonInfo();

        System.out.println("====================================");
        Pokemon myPokeL2 = new PokemonL2(myPoke);
        System.out.println("使用PokemonL2 Class以多型方式進化成功， 您的神奇寶貝為無屬性神奇寶貝");
        System.out.println("成功進化後的寶可夢資訊:");
        myPokeL2.getPokemonInfo();

        System.out.println("====================================");
        Pokemon myPokeL3 = new PokemonL3_polymorphism(myPoke);
        System.out.println("使用PokemonL3_polymorphism Class進化成功， 您的神奇寶貝為無屬性神奇寶貝");
        System.out.println("已經成功進化到最終型態後的寶可夢資訊:");
        myPokeL3.getPokemonInfo();

    }
}
