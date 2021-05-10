package com.cliffside.juc05_Lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *       读    写    锁
 *       |     |
 * 就是共享锁+排他锁
 * 读线程进来拿到锁，如果是读线程可以继续读，但是如果是写线程就得等着
 * 写线程进来拿到锁，所有的都得等着，等我写完其他的再来
 * @author cliffside
 * @date 2020-11-15 21:20
 */
public class L10_ReadWriteLock01 {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
            //模拟写操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }





    public static void main(String[] args) {
        //Runnable readR = ()-> read(lock);
        Runnable readR = ()-> read(readLock);

        //Runnable writeR = ()->write(lock, new Random().nextInt());
        Runnable writeR = ()->write(writeLock, new Random().nextInt());

        for(int i=0; i<18; i++) {
            new Thread(readR).start();
        }
        for(int i=0; i<2; i++) {
            new Thread(writeR).start();
        }


    }

}
