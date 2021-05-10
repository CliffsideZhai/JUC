package com.cliffside.juc05_Lock;

import java.util.concurrent.Exchanger;

/**
 * @author cliffside
 * @date 2020-11-15 21:52
 *
 * 线程之间交换数据
 *
 * 只能两个线程之间进行交换
 *
 * 三个线程及其以上要自己实现线程间通信
 */

public class L12_Exchanger01 {
    static Exchanger<String> exchanger = new Exchanger<>();


    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(()->{
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();


    }

}
