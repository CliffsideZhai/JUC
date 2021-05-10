package com.cliffside.juc08_AQS;

import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2020-11-17 9:19
 */
public class ThreadLocal1 {
    volatile static Person  person = new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(person.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.name = "zhangsan";
        }).start();
    }
}
