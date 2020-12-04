package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class testForPokemon {

    public static void main(String[] args) {

        /*
        // Scanner myScan = new Scanner(System.in);
        // System.out.println("歡迎光臨，請輸入您要的角色代號");
        // int ID = myScan.nextInt();
        // System.out.println(ID + " 您好, 請輸入密碼");
        // String PWD = myScan.next();
        // Player myPlayer = new Player(ID, PWD);
        // System.out.println(ID + " 您好, 請輸入大名");
        // String gName = myScan.next();
        // myPlayer.setName(gName);
        */

        System.out.println("角色建立成功， 您的第一個神奇寶貝為水系神奇寶貝\n");
        WetPokemon firstWetPokemon = new WetPokemon();
        System.out.println("WetPokemon's attack: " + firstWetPokemon.attack);
        firstWetPokemon.singAsong();

        Pokemon.getMap();// test static function
        Pokemon.PokeInfo();// test static function

        Pokemon myPoke = new Pokemon();
        System.out.println("使用Pokemon Class建立成功， 您的第二個神奇寶貝為無屬性神奇寶貝，以下為其資訊:");
        myPoke.getPokemonInfo();

        PokemonL2 myPokeL2 = new PokemonL2(myPoke.ID, myPoke.Name);
        System.out.println("使用PokemonL2 Class進化成功， 您的第二個神奇寶貝為無屬性神奇寶貝，已經成功進化");
        myPokeL2.getEvolutionInfo();

        PokemonL3 myPokeL3 = new PokemonL3(myPokeL2.ID, myPokeL2.Name);
        System.out.println("使用PokemonL3 Class進化成功， 您的第二個神奇寶貝為無屬性神奇寶貝，已經成功進化到最終型態");
        myPokeL3.getEvolutionInfo();

        /*
        // myPlayer.addMyPokemon(animal);
        //
        // System.out.println("請輸入您的帳號與密碼，登入遊戲\n");
        // System.out.println("請輸入帳號");
        // ID = myScan.nextInt();
        // System.out.println("請輸入密碼");
        // PWD = myScan.next();
        // if(myPlayer.login(ID, PWD) == 1){
        // System.out.println("歡迎光臨" + myPlayer.getName());
        // }
        //
        // boolean isTurble = false;
        // Pokemon Pikapika = new Pokemon(1,"匹卡");
        // Pokemon Jenny = new Pokemon(2,"傑尼龜");
        // Jenny.Attack = 80;
        // Jenny.Blood = 150;
        // Jenny.Defence = 120;
        //// while(true) {
        //// System.out.println("匹卡開死!!");
        //// if(Pikapika.Attack(Jenny, isTurble) ==1)
        //// break;
        //// System.out.println("Jenny匹卡開死!!");
        //// if(Jenny.Attack(Pikapika, isTurble)==1)
        //// break;
        //// }
        // myScan.close();
        */

    }
}