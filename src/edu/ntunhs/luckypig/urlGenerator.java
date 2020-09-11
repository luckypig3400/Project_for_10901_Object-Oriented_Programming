package edu.ntunhs.luckypig;

public class urlGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("curl https://zk.sd-dykj.com/2020/09/04/oNDZmcKTlMs6OlJU/out00" + i
                    + ".ts --output out00" + i + ".ts");
        }
        for (int i = 10; i < 100; i++) {
            System.out.println("curl https://zk.sd-dykj.com/2020/09/04/oNDZmcKTlMs6OlJU/out0" + i
                    + ".ts --output out0" + i + ".ts");
        }
        for (int i = 100; i < 688; i++) {
            System.out.println("curl https://zk.sd-dykj.com/2020/09/04/oNDZmcKTlMs6OlJU/out" + i
                    + ".ts --output out" + i + ".ts");
        }
    }
}
