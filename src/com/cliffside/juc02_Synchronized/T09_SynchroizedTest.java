package com.cliffside.juc02_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * 模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 行不行？
 *
 * 容易产生脏读问题（dirtyRead）
 *
 * 能不加锁别加锁，加锁性能会低很多
 * @author windo
 */
public class T09_SynchroizedTest {

    String name;
    double balance;

    public synchronized void setAccount(String name,double balance){
        this.name = name;

        try {
            Thread.sleep(2000);
        }catch (Exception e ){
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        T09_SynchroizedTest t09_synchroizedTest = new T09_SynchroizedTest();
        new Thread(()->t09_synchroizedTest.setAccount("zhangsan",100)).start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e ){
            e.printStackTrace();
        }

        System.out.println(t09_synchroizedTest.getBalance("zhangsan"));

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        }catch (Exception e ){
//            e.printStackTrace();
//        }
        System.out.println(t09_synchroizedTest.getBalance("zhangsan"));
    }
}
