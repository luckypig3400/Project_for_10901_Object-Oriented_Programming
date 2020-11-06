package edu.ntunhs.luckypig.ATM_With_Account_Version;

public class ATM_tester {

    public static void main(String[] args) {

        Account account1 = new Account();

        Account account2 = new Account("072214121", "妤柔(❁´◡`❁)", "121", 66666);

        account1.getAccountInfo();

        account2.getAccountInfo();

    }

}
