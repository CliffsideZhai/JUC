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
public class L04_ReentrantLock04 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(()->{
                try {
                    lock.lock();
                    System.out.println("t1 start");
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                    System.out.println("t1 end");
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }finally {
                    lock.unlock();
                }
            }
        ).start();

        Thread t2 = new Thread(()->{
            try {
                lock.lockInterruptibly();
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        });


        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
