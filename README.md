# Project_for_10901_Object-Oriented_Programming
 Project_for_10901_Object-Oriented_Programming

## Focus in PocketMonsterGameRenew_20201211

# 課堂筆記

### 如果遇到檔案/資料夾無法存取可以嘗試把VScode以系統管理員權限執行
 
 ```java=
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Ex01 {
  public static void main(String[] args) {
	Scanner keyin = new Scanner(System.in); 
	String dirname, filename; //資料夾名稱,檔案名稱
	try {
		System.out.print("請輸入要新增的資料夾名稱:");
		dirname = keyin.next();

		// 宣告一指向檔案名稱為dirname的File類別物件變數fdir，
        // fdir相當於dirname的別名
		File fdir = new File(dirname);
        
        // 若沒有指定路徑，則資料夾會建立在此專案所在的資料夾底
		if (fdir.mkdir())
			System.out.println("資料夾" + dirname + "已經新增完畢!\n");
		else
			System.out.println("資料夾" + dirname + "已經存在或其他原因無法新增! ");

		System.out.print("\n請輸入要新增的檔案名稱:");
		filename = keyin.next();

		// 宣告一指向檔案名稱為filename的File類別物件變數f，
        // f相當於filename的別名
		File f = new File(filename);
           
        // 若沒有指定路徑，則檔案會建立在此專案所在的資料夾底下
		if (f.createNewFile())
			System.out.println("檔案" + filename + "已經新增完畢!\n");
		else
			System.out.println("檔案" + filename + "已經存在或其他原因無法新增! \n ");

		System.out.println(e.getMessage());
		keyin.nextLine();
	}
   keyin.close();
  }
}

 ```

### 類別內盡量不要使用Scanner 和 System out
+ 在內別內盡量只放和該類別有關的變數和方法就好
+ 使用傳入傳出值(回傳值) 來與外部進行資訊交換
+ EX: 有個類別叫做Pokemon裡面有個getLocation()方法
+ 不要於getLocation內直接使用System.out.println()來輸出資訊
+ 而是用回傳值如:return location

### 增加程式碼的易讀性
```java=
if(eWallet.withdraw(paymentAmount) == 1){
    //...
}
//V.S
if(1 == eWallet.withdraw(paymentAmount)){
    //...
}
```

▲ 上面的程式碼執行起來是一樣的，但是下方的版本易讀性會較高

```java=
//eWallet.withdraw() status code:
//0 = 提款失敗
//1 = 提款成功
//2 = 提款成功，並且今日提款額度已達上限
if(eWallet.withdraw(paymentAmount) == 1){
    //...
}else if(eWallet.withdraw(paymentAmount) == 2){
    //...
}else if(eWallet.withdraw(paymentAmount) == 3){
    //...
}
//V.S
if(1 == eWallet.withdraw(paymentAmount)){
    //...
}else if(2 == eWallet.withdraw(paymentAmount)){
    //...
}else if(3 == eWallet.withdraw(paymentAmount)){
    //...
}
```
▲在程式碼長短不一時把比較值放在if()前面會比較易讀
(或許看起來比較舒服吧)