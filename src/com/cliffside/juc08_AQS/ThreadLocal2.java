package com.cliffside.juc08_AQS;

import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2020-11-17 9:19
 */
public class ThreadLocal2 {

    static ThreadLocal<Person> local = new ThreadLocal<>();
    //这里会将这些设计成线程独有的person

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(local.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            local.set(new Person());
        }).start();
    }

    static class Person{
        String name = "zhangssssss";
    }
}
