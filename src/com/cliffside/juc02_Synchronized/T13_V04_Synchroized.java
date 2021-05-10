package com.cliffside.juc02_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某个对象O，如果对象O的属性发生改变，不影响锁的使用，
 * 但是如果O变成另外一个对象，则锁定的对象发生改变，
 * 应该避免将锁定的对象的引用变成别的对象。加final可以达到目的。
 * @author cliffside
 * @date 2020-11-15 15:49
 */
public class T13_V04_Synchroized {
    final Object object = new Object();

    void test(){
        synchronized (object){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(object.hashCode());
        }
    }

    public static void main(String[] args) {
        T13_V04_Synchroized t13_v04_synchroized = new T13_V04_Synchroized();
        new Thread(t13_v04_synchroized::test,"test01").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(t13_v04_synchroized::test, "test02");
       // t13_v04_synchroized.object = new Object();

        thread.start();
    }
}
