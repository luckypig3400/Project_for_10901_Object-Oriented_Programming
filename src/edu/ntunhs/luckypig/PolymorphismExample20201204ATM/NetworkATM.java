package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

public class NetworkATM extends ATM {

    private int Bonus;

    NetworkATM() {
        super();
    }

    NetworkATM(String in_ID, String in_Name, String in_PWD) {
        super(in_ID, in_Name, in_PWD);
        Bonus = 0;
    }

    /**
     * @param depositAmount, 輸入存款金額
     * @return if true, 存款成功; false, 輸入錯誤
     */
    boolean deposit(int depositAmount) {
        if (depositAmount < 0) {
            return false; // 存款金額<0, 錯誤狀態
        } else { // 存款的動作
            Balance = Balance + depositAmount; // Balance +=gMoney;
            Bonus += 7;
            System.out.println("NetworkATM 存款成功~! ");
            return true; // 存款成功狀態
        }
    }

    int withdraw(int withdrawAmount) {
        if (0 > withdrawAmount)
            return 0;
        if (Balance >= withdrawAmount) {
            Balance -= withdrawAmount;
            Bonus += 7;// 使用網銀提款增加紅利點數
            return 1;
        } else
            return 0;
    }

    int getBonus(){
        return Bonus;
    }
}
