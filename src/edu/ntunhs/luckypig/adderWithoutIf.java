package edu.ntunhs.luckypig;

import java.util.Scanner;

public class adderWithoutIf 
{

    public static void main(String[] args) 
    {   
        
        Scanner sc=new  Scanner(System.in);
        int n=0;
        int total=0;
        System.out.println("請輸入一整數");
        n=sc.nextInt();
        while(n>=0)
        {   total=total+n;
            System.out.println("total:"+total);
            System.out.println("請輸入一整數");
            n=sc.nextInt();
        }
        System.out.println("城市結束");




    }

}
