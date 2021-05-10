package com.cliffside.juc05_Lock;
//JUC的同步锁

import java.util.concurrent.TimeUnit;

/**
 * reentrantLock(可折返、再进去)
 * 用于替代synchronized
 * 本例中由于m1锁定this，只有m1执行完毕后，m2才能执行，
 * 复习synchronized最原始的语义
 * @author cliffside
 * @date 2020-11-15 19:09
 */
public class L01_ReentrantLock01 {

    synchronized void m1(){
        for (int i = 0;i<10;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i==2) {m2();}
            //调用了加锁的m2，锁的可重入。就是在一个线程中再次申请这个锁
        }
    }

    synchronized void m2(){
        System.out.println("m2>>>>>>>>>>>>>>");
    }

    public static void main(String[] args) {
        L01_ReentrantLock01 l01_reentrantLock01 = new L01_ReentrantLock01();
        new Thread(l01_reentrantLock01::m1,"m1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(l01_reentrantLock01::m2,"m2").start();
    }
}
