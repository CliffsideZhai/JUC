package com.cliffside.juc05_Lock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 公平锁
 */
public class L05_ReentrantLock05 extends Thread{
    private static ReentrantLock lock  = new ReentrantLock(true);

    public void  run(){
        for (int i =0;i<100;i++){
            lock.lock();
            try {
              System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        L05_ReentrantLock05 l05_reentrantLock05 = new L05_ReentrantLock05();
        Thread thread = new Thread(l05_reentrantLock05);
        Thread thread1 = new Thread(l05_reentrantLock05);
        thread.start();
        thread1.start();
    }
}
