package com.cliffside.juc01;

import java.util.concurrent.Executors;

public class T02_HowToCreateThread {
    /**
     * 第一种方式，从Thread继承
     *重写run方法
     */
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    /**
     *第二种方法，实现runnable接口
     * 实现run方法
     */
    static class  MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun");
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(() ->{
            System.out.println("Hello Lambda");
        }).start();//lambda表达式启线程
    }


    /**
     * 第三种：通过线程池来启动,Executors.newCachedThread
     * 线程池里的启动方式其实还是第一种和第二种
     */
}
