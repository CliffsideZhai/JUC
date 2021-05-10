package com.cliffside.juc05_Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author cliffside
 * @date 2020-11-15 20:26
 * 可循环屏障
 *
 * 需要等前面操作执行完毕之后才能继续执行，
 * 比如一个线程-数据库；一个线程-网络；一个线程-文件。
 * 等到这三个线程全都执行完毕之后才继续执行后面操作。
 */
public class L07_CyclicBarrier01 {
    public static void main(String[] args) {
        //CyclicBarrier barrier = new CyclicBarrier(20);

        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人发车"));

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("ˣ");
            }
        });*/

        for(int i=0; i<100; i++) {

            new Thread(()->{
                try {
                    //每个线程来这里等着，什么时候到了屏障限定的个数，什么时候发车
                    barrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

}
