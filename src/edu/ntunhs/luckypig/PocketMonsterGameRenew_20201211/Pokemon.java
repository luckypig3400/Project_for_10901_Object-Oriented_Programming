package edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211;

import java.util.Random;
import edu.ntunhs.luckypig.PocketMonsterGameRenew_20201211.RandomString;
// 其實只需要引入位於 edu.ntunhs.luckypig 的 RandomString 即可
// import edu.ntunhs.luckypig.RandomString;
// 但是為了方便繳交作業，因此複製一份到同個資料夾內

public class Pokemon {

    interface move { // maybe use it in the map system
        int run(int movementX, int movementY);

        int fly(int movementX, int movementY);
    }

    interface evolution {
        int evolutionToType2(int currentType);

        int evolutionToType3(int currentType);
    }

    abstract class abstractPokemon {
        int type;// 寶可夢具有三種型態1、2、3
        // 1為初始型態、3為最終進化型態
        int level;// 寶可夢具有等級，其上限為99等
        int exp;// 使用經驗值來判斷寶可夢等級
        // 寶可夢被擊敗的話會掉落身上9%經驗值給對方但自身經驗不會減少
        String attribute = "none";// 寶可夢具有6種屬性
        // none為無屬性、water為水屬性、fire為火屬性、wood為木屬性、light為光屬性、dark為暗屬性
        // 日後可以使用屬性來做相剋加減傷
        int ID;
        String Name;
        int currentLocationX, currentLocationY;// 這隻寶可夢在地圖上的位置
        int HP, ATK, DEF, agile;// 三圍數值 與 敏捷度
        // 於戰鬥系統中使用寶可夢的敏捷度來決定先攻順序
        int maxHP;// 使用回血時血量不可超過血量上限
        double dodgeRate, criticalRate;// 閃避率 與 爆擊率
        // float and double datatype in Java
        // https://stackoverflow.com/questions/27598078/float-and-double-datatype-in-java
        boolean defendStatus;// 玩家選擇防禦後紀錄防禦狀態
    }

    public class PokemonNoneAttribute extends abstractPokemon implements move, evolution {
        Random rnd = new Random();
        RandomString rndString = new RandomString();

        public PokemonNoneAttribute() {// default constructor provides random generate ID、Name and more...
            type = 1;
            level = 1;
            exp = 0;
            attribute = "none";
            ID = rnd.nextInt(999999999);// 寶可夢編號上限
            Name = rndString.nextString();// 隨機幫寶可夢取名字
            currentLocationX = rnd.nextInt(65532);// 或許日後可以寫地圖
            currentLocationY = rnd.nextInt(65532);
            maxHP = HP = rnd.nextInt(300) + 600;
            ATK = rnd.nextInt(66) + 100;
            DEF = rnd.nextInt(30) + 90;
            agile = rnd.nextInt(15) + 9;// 敏捷度上限100，對戰時敏捷度高的先攻
            dodgeRate = 9;// default dodgeRate = 9%
            criticalRate = 6;// defaule criticalRate = 6%
            defendStatus = false;
        }

        public PokemonNoneAttribute(int in_ID, String in_Name) {
            type = 1;
            level = 1;
            exp = 0;
            attribute = "none";
            ID = in_ID;
            Name = in_Name;
            currentLocationX = rnd.nextInt(65532);// 或許日後可以寫地圖
            currentLocationY = rnd.nextInt(65532);
            maxHP = HP = rnd.nextInt(300) + 600;
            ATK = rnd.nextInt(66) + 100;
            DEF = rnd.nextInt(30) + 90;
            agile = rnd.nextInt(15) + 9;// 敏捷度上限100，對戰時敏捷度高的先攻
            dodgeRate = 9;// default dodgeRate = 9%
            criticalRate = 6;// defaule criticalRate = 6%
            defendStatus = false;
        }

        public PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF) {
            type = 1;
            level = 1;
            exp = 0;
            attribute = "none";
            currentLocationX = rnd.nextInt(65532);// 或許日後可以寫地圖
            currentLocationY = rnd.nextInt(65532);
            ID = in_ID;
            Name = in_Name;
            maxHP = HP = in_HP;
            ATK = in_ATK;
            DEF = in_DEF;
            dodgeRate = 9;// still use default avoid rate here
            agile = rnd.nextInt(15) + 9;// 敏捷度上限100，對戰時敏捷度高的先攻
            criticalRate = 6;// defaule criticalRate = 6%
            defendStatus = false;
        }

        public PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_agile) {
            type = 1;
            level = 1;
            exp = 0;
            attribute = "none";
            currentLocationX = rnd.nextInt(65532);// 或許日後可以寫地圖
            currentLocationY = rnd.nextInt(65532);
            ID = in_ID;
            Name = in_Name;
            maxHP = HP = in_HP;
            ATK = in_ATK;
            DEF = in_DEF;
            dodgeRate = 9;// still use default avoid rate here
            agile = in_agile;
            criticalRate = 6;
            defendStatus = false;
        }

        public PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_agile,
                double in_criticalRate) {
            type = 1;
            level = 1;
            exp = 0;
            attribute = "none";
            currentLocationX = rnd.nextInt(65532);// 或許日後可以寫地圖
            currentLocationY = rnd.nextInt(65532);
            ID = in_ID;
            Name = in_Name;
            maxHP = HP = in_HP;
            ATK = in_ATK;
            DEF = in_DEF;
            dodgeRate = 9;// still use default avoid rate here
            agile = in_agile;
            criticalRate = in_criticalRate;
            defendStatus = false;
        }

        public PokemonNoneAttribute(int in_ID, String in_Name, int in_HP, int in_ATK, int in_DEF, int in_agile,
                double in_criticalRate, double in_dodgeRate) {
            type = 1;
            level = 1;
            exp = 0;
            attribute = "none";
            currentLocationX = rnd.nextInt(65532);// 或許日後可以寫地圖
            currentLocationY = rnd.nextInt(65532);
            ID = in_ID;
            Name = in_Name;
            maxHP = HP = in_HP;
            ATK = in_ATK;
            DEF = in_DEF;
            dodgeRate = in_dodgeRate;// if set to 100 will become a super boss in game
            agile = in_agile;
            criticalRate = in_criticalRate;
            defendStatus = false;
        }

        public int getCurrentHP() {
            return HP;
        }

        public void printCurrentHP() {
            System.out.println("目前HP:" + HP);
        }

        public void setCurrentHP(int in_HP) {
            HP = in_HP;
            System.out.println("成功設定當前HP，目前HP:" + HP);
        }

        public int getMaxHP() {
            return maxHP;
        }

        public void printMaxHP() {
            System.out.println("目前HP上限:" + maxHP);
        }

        public void setMaxHP(int in_maxHP) {
            maxHP = in_maxHP;
            System.out.println("成功設定HP上限，目前maxHP:" + maxHP);
        }

        public int getATK() {
            return ATK;
        }

        public void printATK() {
            System.out.println("目前ATK:" + ATK);
        }

        public void setATK(int in_ATK) {
            ATK = in_ATK;
            System.out.println("成功設定ATK，目前ATK:" + ATK);
        }

        public int getDEF() {
            return DEF;
        }

        public void printDEF() {
            System.out.println("目前DEF:" + DEF);
        }

        public void setDEF(int in_DEF) {
            DEF = in_DEF;
            System.out.println("成功設定DEF，目前DEF:" + DEF);
        }

        public int getAgile() {
            return agile;
        }

        public void printAgile() {
            System.out.println("目前敏捷:" + agile);
        }

        public void setAgile(int in_agile) {
            agile = in_agile;
            System.out.println("成功設定敏捷，目前敏捷:" + agile);
        }

        public double getDodgeRate() {
            return dodgeRate;
        }

        public void printDodgeRate() {
            System.out.println("目前閃避率:" + dodgeRate + "%");
        }

        public void setDodgeRate(double in_dodgeRate) {
            dodgeRate = in_dodgeRate;
            System.out.println("成功設定閃避率，目前閃避率:" + dodgeRate + "%");
        }

        public double getCriticalRate() {
            return criticalRate;
        }

        public void printCriticalRate() {
            System.out.println("目前暴擊率:" + criticalRate + "%");
        }

        public void setCriticalRate(double in_criticalRate) {
            criticalRate = in_criticalRate;
            System.out.println("成功設定暴擊率，目前暴擊率:" + criticalRate + "%");
        }

        public void printPokemonInfo() {
            System.out.println("ID:" + ID + "\tName:" + Name + "\nLevel:" + level + "\t屬性:" + attribute + "\n當前型態:第"
                    + type + "型態(第3型態為最終型態)" + "\nHP:" + HP + "\tATK:" + ATK + "\tDEF:" + DEF + "\n敏捷度:" + agile
                    + "\t閃避率:" + dodgeRate + "%\t爆擊率:" + criticalRate + "%\nCurrent Location:(" + currentLocationX
                    + ", " + currentLocationY + ")");
        }

        public String getPokemonInfo() {
            String outputString = "ID:" + ID + "\tName:" + Name + "\nLevel:" + level + "\t屬性:" + attribute + "\n當前型態:第"
                    + type + "型態(第3型態為最終型態)" + "\nHP:" + HP + "\tATK:" + ATK + "\tDEF:" + DEF + "\n敏捷度:" + agile
                    + "\t閃避率:" + dodgeRate + "%\t爆擊率:" + criticalRate + "%\nCurrent Location:(" + currentLocationX
                    + ", " + currentLocationY + ")";
            return outputString;
        }

        @Override
        public int evolutionToType2(int currentType) {
            // TODO check current type and evolutionToType2 with 3values increase
            return 0;
        }

        @Override
        public int evolutionToType3(int currentType) {
            // TODO check current type and evolutionToType3 with 3values increase
            return 0;
        }

        @Override
        public int run(int movementX, int movementY) {
            currentLocationX += movementX;
            currentLocationY += movementY;
            return 0;
        }

        @Override
        public int fly(int movementX, int movementY) {
            currentLocationX += movementX * 2;
            currentLocationY += movementY * 2;
            return 0;
        }

    }

}
