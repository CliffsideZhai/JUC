package com.cliffside.juc05_Lock;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 限流。最多允许多少个线程同时执行。
 *
 * 类似车道和收费站
 * @author cliffside
 * @date 2020-11-15 21:39
 */
public class L11_Semaphore01 {
    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(1, true);
        //默认非公平
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        new Thread(()->{
            try {
                //获得一个信号量
                s.acquire();

                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放信号量
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();
    }

}
