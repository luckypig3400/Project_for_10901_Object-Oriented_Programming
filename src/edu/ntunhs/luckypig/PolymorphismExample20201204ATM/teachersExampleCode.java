package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

public class teachersExampleCode {

}

class ATM {
    private String Name, ID, PWD;
    int Balance;

    int withdraw(int gMoney) {
        if (0 > gMoney)
            return 0;
        Balance += gMoney;
        return 1;
    }
}

class NetworkATM extends ATM {
    private String Name, ID, PWD;
    private int Bonus = 0;

    /**
     * @param gMoney, 輸入存款金額
     * @return if true, 存款成功; false, 輸入錯誤
     */
    boolean deposit(int gMoney) {
        if (gMoney < 0) {
            return false; // 存款金額<0, 錯誤狀態
        } else { // 存款的動作
            Balance = Balance + gMoney; // Balance +=gMoney;
            Bonus += 7;
            System.out.println("NetworkATM 存款成功~! ");
            return true; // 存款成功狀態
        }
    }

    int withdraw(int gMoney) {
        if (0 > gMoney)
            return 0;
        Balance += gMoney;
        Bonus += 7;
        return 1;
    }

}

/* 電子錢包付費功能範例 */

class NTUNHSpay {
    ATM eWallet;
    private int Bonus;

    NTUNHSpay() {
        eWallet = new NetworkATM();
        Bonus = 0;
    }

    int payment(int gMoney) {
        if (eWallet.withdraw(gMoney) == 1) {
            System.out.println("電子付款成功~! ");
            return 1;
        } else {
            return 0;
        }
    }

    int Register(int gMoney) {
        return 0;
    }
}

###多型
/* 範例一：人種 */
http:// justbm.blogspot.com/2013/03/polymorphism.html

/* 範例二：網路銀行電子錢包 */
class ATM {
    private String Name, ID, PWD;
    int Balance;

    class NetworkATM extends ATM {
        private String Name, ID, PWD;
        private int Bonus = 0;

        /**
         * @param gMoney, 輸入存款金額
         * @return if true, 存款成功; false, 輸入錯誤
         */
        boolean deposit(int gMoney) {
            if (gMoney < 0) {
                return false; // 存款金額<0, 錯誤狀態
            } else { // 存款的動作
                Balance = Balance + gMoney; // Balance +=gMoney;
                Bonus += 7;
                System.out.println("NetworkATM 存款成功~! ");
                return true; // 存款成功狀態
            }
        }

    }

    /* 電子錢包付費功能範例 */

class NTUNHSpay {
    ATM eWallet;
    private int Bonus;
    
    NTUNHSpay(){
        eWallet = new NetworkATM();
        Bonus =0;
    }
    
    int payment(int gMoney){
        if(1 == eWallet.withdraw(gMoney)) {
            System.out.println("電子付款成功~! ");
            Bonus+=7;
            return 1;
        }        
        else {
            return 0;
        }
    }
    
    int Register(int gMoney){
        return 0;
    }           
}