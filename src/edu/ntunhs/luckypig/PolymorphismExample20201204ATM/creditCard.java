package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

public class creditCard extends ATM{
    
    private int Bonus;
    //信用卡與網銀的以及北護PAY的紅利點數是不同的

    creditCard(){
        super();
        Bonus = 0;
    }
    
    //信用卡只能存取提款功能(用來付帳)，不具有存款功能
    int withdraw(int withdrawAmount) {
        if (0 > withdrawAmount)// 輸入金額錯誤，不可小於0
            return 0;
        if (Balance >= withdrawAmount) {
            Balance -= withdrawAmount;
            return 1;
        } else
            return 0;
    }

    int getBonus(){
        return Bonus;
    }
}
