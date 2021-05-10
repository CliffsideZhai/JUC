package com.cliffside.juc02_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 *
 * synchronized可重入，
 * 一个同步方法可以调用另一个同步方法，
 * 一个线程可以拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
 * 也就是说，synchronized获得的锁时可重入的。
 * @author cliffside
 * @date 2020-11-15 10:44
 */
public class T010_Synchronized {
    synchronized void test01(){
        System.out.println("test01 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test02();

    }

    synchronized void test02(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test02 start");
    }

    public static void main(String[] args) {
        new T010_Synchronized().test01();
    }
}
