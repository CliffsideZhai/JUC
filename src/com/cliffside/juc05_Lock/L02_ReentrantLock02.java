package com.cliffside.juc05_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantLock(可折返、再进去)【手动解锁】
 * 用于替代synchronized(自动解锁)
 * 本例中由于m1锁定this，只有m1执行完毕后，m2才能执行，
 * 复习synchronized最原始的语义
 * @author cliffside
 * @date 2020-11-15 19:09
 */
public class L02_ReentrantLock02 {
    Lock lock = new ReentrantLock();
    void m1(){
        try {
            lock.lock();
            for (int i = 0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
                if (i==2) {m2();}
                    //调用了加锁的m2，锁的可重入。就是在一个线程中再次申请这个锁
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    /**
     * 比synchronized强在
     * 使用trylock进行尝试锁定，不管锁定与否，方法就将继续执行
     * 可以根据trylock的返回值来判定是否锁定
     * 也可以指定trylock的时间，由于trylock(time)抛出异常，要注意unlock的
     */
     void m2(){
        try {
            lock.lock();
            System.out.println("m2>>>>>>>>>>>>>>");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        L02_ReentrantLock02 l01_reentrantLock01 = new L02_ReentrantLock02();
        new Thread(l01_reentrantLock01::m1,"m1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(l01_reentrantLock01::m2,"m2").start();
    }
}
