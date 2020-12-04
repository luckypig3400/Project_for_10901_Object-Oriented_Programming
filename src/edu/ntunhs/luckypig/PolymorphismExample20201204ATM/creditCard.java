package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

public class creditCard extends ATM{
    
    private int Bonus;
    //信用卡與網銀的以及北護PAY的紅利點數是不同的

    creditCard(){
        super();
        Bonus = 0;
    }
    
    int getBonus(){
        return Bonus;
    }
}
