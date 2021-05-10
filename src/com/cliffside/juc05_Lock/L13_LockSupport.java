package com.cliffside.juc05_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author cliffside
 * @date 2020-11-16 8:58
 *
 * 不用加锁可以实现线程的随停随起
 * 底层也是unsafe的park方法实现
 */
public class L13_LockSupport {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i =0; i<10;i++){
                System.out.println(i);
                if (i ==5){
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("这里睡眠结束");
        //LockSupport.unpark(thread);
    }

}
