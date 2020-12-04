package edu.ntunhs.luckypig.PolymorphismExample20201204ATM;

public class ATM {
    private String ID, Name, PWD;
    int Balance;

    ATM(String in_ID, String in_Name, String in_PWD) {
        ID = in_ID;
        Name = in_Name;
        PWD = in_PWD;
        Balance = 0;
    }

    int withdraw(int withdrawAmount) {
        if (0 > withdrawAmount)// 輸入金額錯誤，不可小於0
            return 0;
        if (Balance >= withdrawAmount) {
            Balance -= withdrawAmount;
            return 1;
        } else
            return 0;
    }

    void SetBalance(int gMoney) {
        Balance += gMoney;
    }

    int getBalance() {
        return Balance;
    }

    String getAccountInfo(){
        return Name + "您好~ 您的帳號ID:" + ID + "剩餘餘額:" + Balance;
    }

    void login(String in_ID,String in_PWD){
        if(in_PWD.equals(PWD)){
            //maybe do something later
        }
    }
}
