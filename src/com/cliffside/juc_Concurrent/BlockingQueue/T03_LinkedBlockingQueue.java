package com.cliffside.juc_Concurrent.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2020-11-17 20:05
 */
public class T03_LinkedBlockingQueue {

    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();

    static Random r = new Random();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    strs.put("a" + i); //put和take实现了阻塞。如果满了，就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "p1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take -" + strs.take()); //如果空了，就会等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "c" + i).start();

        }
    }

}
