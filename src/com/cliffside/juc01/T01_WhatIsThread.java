package com.cliffside.juc01;

import java.util.concurrent.TimeUnit;

/**
 * @author windo
 *
 * 线程：一个程序里，不同的执行路径
 */
public class T01_WhatIsThread {
    private static class T1 extends Thread {
        @Override
        public void run() {
            for (int i=0 ; i<10 ;i++){
                try{
                    TimeUnit.MICROSECONDS.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
        //new T1().run(); //run方法启动相当于main执行，先执行t1 再继续执行main，只有一条执行路径
        new T1().start();//start 启动，相当于main运行的同时，t1也在运行
        for (int i=0 ; i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("this is main");
        }

    }
}
