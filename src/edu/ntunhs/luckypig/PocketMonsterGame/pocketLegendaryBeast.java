package edu.ntunhs.luckypig.PocketMonsterGame;

public class pocketLegendaryBeast extends PocketMonster{
    
    pocketLegendaryBeast(){
        super();
    }

    pocketLegendaryBeast(String in_name){
        super(in_name);
    }

}

class test{
    public static void main(String[] args) {
        
        pocketLegendaryBeast LB1 = new pocketLegendaryBeast("神獸1號");
        LB1.getPocketMonsterInfo();

    }
}