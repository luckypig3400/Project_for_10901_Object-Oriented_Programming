package edu.ntunhs.luckypig.PocketMonsterGame;

import java.util.Random;
import java.util.Scanner;

public class PocketMonsterAudiResetVersion{
    public static void main(String[] args) {
        int A_random;
        int B_random;
        int a_count = 10;
        int b_count = 10;
        boolean esc = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入玩家A的名稱");

        System.out.print("=>");
        String PlayerA = sc.nextLine();
        System.out.println("請輸入玩家B的名稱");
        System.out.print("=>");
        String PlayerB = sc.nextLine();

        Jenny.Name = Jenny.getName();
        Jenny.HP = Jenny.getHP();
        Jenny.ATK = Jenny.getATK();
        Jenny.DEF = Jenny.getDEF();
        Pikapika.Name = Pikapika.getName();
        Pikapika.HP = Pikapika.getHP();
        Pikapika.ATK = Pikapika.getATK();
        Pikapika.DEF = Pikapika.getDEF();
        /*
         * System.out.println(Jenny.Name); System.out.println(Jenny.HP);
         * System.out.println(Jenny.ATK); System.out.println(Pikapika.Name);
         * System.out.println(Pikapika.HP); System.out.println(Pikapika.ATK);
         */
        Random rand = new Random(); // instance of random class
        Scanner KeyIn = new Scanner(System.in);
        while (esc) {
            System.out.println("請" + PlayerA + "選擇技能");
            int A_skill = KeyIn.nextInt();
            System.out.println("請" + PlayerB + "選擇技能");
            int B_skill = KeyIn.nextInt();
            if (A_skill == 1 && B_skill == 1) {
                A_random = rand.nextInt(100);
                if (A_random > 70) {
                    System.out.println(Pikapika.Name + "沒中 ");
                } else if (A_random > 50) {
                    Jenny.HP -= 2 * Pikapika.ATK;
                    System.out.println("Turbo");
                    System.out.println(Jenny.Name + "還剩下" + Jenny.HP + "滴血");
                } else if (A_random > 40) {
                    Jenny.HP -= Pikapika.ATK / 2;
                    System.out.println("so sad! only half");
                    System.out.println(Jenny.Name + "還剩下" + Jenny.HP + "滴血");
                } else {

                    Jenny.HP -= Pikapika.ATK;
                    System.out.println("Normal!!");
                    System.out.println(Jenny.Name + "還剩下" + Jenny.HP + "滴血");
                }

                B_random = rand.nextInt(100);
                if (B_random > 70) {
                    System.out.println(Jenny.Name + "沒中 ");
                } else if (B_random > 50) {

                    Pikapika.HP -= 2 * Jenny.ATK;
                    System.out.println("Turbo");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else if (B_random > 40) {

                    Pikapika.HP -= Jenny.ATK / 2;
                    System.out.println("so sad! only half");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else {

                    Pikapika.HP -= Jenny.ATK;
                    System.out.println("Normal!!");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                }

            } else if (A_skill == 2 || B_skill == 1) {
                System.out.println(Pikapika.Name + "採取了守備姿勢");
                B_random = rand.nextInt(100);
                if (B_random > 50) {
                    System.out.println(Jenny.Name + "沒中 ");
                } else if (B_random > 30) {
                    Pikapika.HP -= 2 * Jenny.ATK;
                    System.out.println("Turbo");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else if (B_random > 20) {
                    Pikapika.HP -= Jenny.ATK / 2;
                    System.out.println("so sad! only half");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else {

                    Pikapika.HP -= Jenny.ATK;
                    System.out.println("Normal!!");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                }
            } else if (A_skill == 3 || B_skill == 1) {
                System.out.println(Pikapika.Name + "喝下了恢復藥水");
                A_random = rand.nextInt(20);
                if (a_count > 0) {
                    a_count--;
                    Pikapika.HP += A_random;
                    System.out.println(Pikapika.Name + "共恢復了" + A_random + "滴血量，還剩" + a_count + "瓶恢復藥水");
                } else {
                    System.out.println("恢復藥水用光囉");
                }
                B_random = rand.nextInt(100);
                if (B_random > 50) {
                    System.out.println(Jenny.Name + "沒中 ");
                } else if (B_random > 30) {
                    Pikapika.HP -= 2 * Jenny.ATK;
                    System.out.println("Turbo");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else if (B_random > 20) {
                    Pikapika.HP -= Jenny.ATK / 2;
                    System.out.println("so sad! only half");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else {

                    Pikapika.HP -= Jenny.ATK;
                    System.out.println("Normal!!");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                }
            } else if (A_skill == 1 || B_skill == 2) {
                System.out.println(Jenny.Name + "採取了守備姿勢");
                A_random = rand.nextInt(100);
                if (A_random > 50) {
                    System.out.println(Pikapika.Name + "沒中 ");
                } else if (A_random > 30) {
                    Jenny.HP -= 2 * Pikapika.ATK;
                    System.out.println("Turbo");
                    System.out.println(Jenny.Name + "還剩下" + Jenny.HP + "滴血");
                } else if (A_random > 20) {
                    Jenny.HP -= Pikapika.ATK / 2;
                    System.out.println("so sad! only half");
                    System.out.println(Jenny.Name + "還剩下" + Jenny.HP + "滴血");
                } else {

                    Jenny.HP -= Pikapika.ATK;
                    System.out.println("Normal!!");
                    System.out.println(Jenny.Name + "還剩下" + Jenny.HP + "滴血");
                }
            }

            else if (A_skill == 1 || B_skill == 3) {
                System.out.println(Jenny.Name + "喝下了恢復藥水");
                B_random = rand.nextInt(20);
                if (b_count > 0) {
                    b_count--;
                    System.out.println(Jenny.Name + "共恢復了" + B_random + "滴血量，還剩" + b_count + "瓶恢復藥水");
                    Jenny.HP += B_random;

                } else {
                    System.out.println("恢復藥水用光囉");
                }

                B_random = rand.nextInt(100);
                if (B_random > 50) {
                    System.out.println(Jenny.Name + "沒中 ");
                } else if (B_random > 30) {
                    Pikapika.HP -= 2 * Jenny.ATK;
                    System.out.println("Turbo");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else if (B_random > 20) {
                    Pikapika.HP -= Jenny.ATK / 2;
                    System.out.println("so sad! only half");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                } else {

                    Pikapika.HP -= Jenny.ATK;
                    System.out.println("Normal!!");
                    System.out.println(Pikapika.Name + "還剩下" + Pikapika.HP + "滴血");
                }

            } else if (A_skill == 3 || B_skill == 3) {
                System.out.println(Pikapika.Name + "喝下了恢復藥水");
                A_random = rand.nextInt(20);
                if (a_count > 0) {
                    a_count--;
                    Pikapika.HP += A_random;
                    System.out.println(Pikapika.Name + "共恢復了" + A_random + "滴血量，還剩" + a_count + "瓶恢復藥水");
                } else {
                    System.out.println(Pikapika.Name + "恢復藥水用光囉");
                }

                System.out.println(Jenny.Name + "喝下了恢復藥水");
                B_random = rand.nextInt(20);
                if (b_count > 0) {
                    b_count--;
                    System.out.println(Jenny.Name + "共恢復了" + B_random + "滴血量，還剩" + b_count + "瓶恢復藥水");
                    Jenny.HP += B_random;

                } else {
                    System.out.println(Jenny.Name + "恢復藥水用光囉");
                }
            }

            if (Jenny.HP <= 0) {
                System.out.println("OH" + Jenny.Name + " die!!");
                esc = false;
            }
            if (Pikapika.HP <= 0) {

                System.out.println("OH" + Pikapika.Name + " die!!");
                esc = false;
            }
        }

        sc.close();
        KeyIn.close();
        
    }
}

class Pikapika extends pokemon {

    public static String getName() {
        return Name = "Pikapika";

    }

    public static int getHP() {
        HP = 200;
        return HP;
    }

    public static int getATK() {
        ATK = 15;
        return ATK;
    }

    public static int getDEF() {
        DEF = 5;
        return DEF;
    }

}

class Jenny extends pokemon {

    static int HP = 180;
    static int ATK = 10;
    static int DEF = 10;
    static String Name;

    public static String getName() {
        return Name = "Jenny";

    }

    public static int getHP() {

        return HP;
    }

    public static int getATK() {

        return ATK;
    }

    public static int getDEF() {

        return DEF;
    }

}

class pokemon {
    int ID;
    static int HP;
    static int ATK;
    static int DEF;
    static String Name;
    int Type;
    int Wallet;
    float Exp;
}
