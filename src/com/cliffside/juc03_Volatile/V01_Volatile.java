package com.cliffside.juc03_Volatile;


import java.util.concurrent.TimeUnit;

/**
 *
 * volatile
 * 保证线程可见性——————MESI、MSI等缓存一致性协议
 * 禁止指令重排序
 * @author cliffside
 * @date 2020-11-15 14:42
 */
public class V01_Volatile {
    volatile boolean running= true ;
    void test(){
        System.out.println("V01 start");
        while (running){
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("V01 end");
    }

    public static void main(String[] args) {
        V01_Volatile v01_volatile = new V01_Volatile();

        new Thread(v01_volatile::test,"test").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        v01_volatile.running = false;
    }
}
