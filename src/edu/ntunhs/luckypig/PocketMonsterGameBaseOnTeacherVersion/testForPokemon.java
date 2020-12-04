package edu.ntunhs.luckypig.PocketMonsterGameBaseOnTeacherVersion;

public class testForPokemon {

    public static void main(String[] args) {
        // Scanner myScan = new Scanner(System.in);
        // System.out.println("歡迎光臨，請輸入您要的角色代號");
        // int ID = myScan.nextInt();
        // System.out.println(ID + " 您好, 請輸入密碼");
        // String PWD = myScan.next();
        // Player myPlayer = new Player(ID, PWD);
        // System.out.println(ID + " 您好, 請輸入大名");
        // String gName = myScan.next();
        // myPlayer.setName(gName);

        System.out.println("角色建立成功， 您的第一個神奇寶貝為傑尼龜\n");
        WetPokemon animal = new WetPokemon();
        System.out.println("WetPokemon's attack: " + animal.Attack);
        animal.singAsong();

        Pokemon myPoke = new Pokemon();
        Pokemon.getMap();
        Pokemon.PokeInfo();

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
    }
}