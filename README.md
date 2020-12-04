# Project_for_10901_Object-Oriented_Programming
 Project_for_10901_Object-Oriented_Programming

# 課堂筆記
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