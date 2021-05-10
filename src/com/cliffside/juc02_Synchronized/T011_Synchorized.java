package com.cliffside.juc02_Synchronized;

import java.util.concurrent.TimeUnit;

/**
 *
 * 程序在执行过程中，如果出现异常，默认情况下锁会被释放
 *
 * 所以在并发处理的过程中，有异常要多加小心，不然可能导致不一致的情况。
 * 比如在一个web app处理过程中，多个servlet线程共同访问同一个资源，
 * 这时如果异常处理不合适，在第一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到
 * 异常产生时的数据，因此要小心的处理同步业务中的异常
 * @author cliffside
 * @date 2020-11-15 10:51
 */
public class T011_Synchorized {
    int count =0;
    synchronized void test(){
        System.out.println(Thread.currentThread().getName()+"start");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+"count = "+ count );
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5){
                int i = 1/0;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){
        T011_Synchorized t011_synchorized = new T011_Synchorized();
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                t011_synchorized.test();
            }
        };
        new Thread(runnable,"test01").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(runnable,"test02").start();
    }

}
