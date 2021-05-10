package com.cliffside.juc02_Synchronized;

/**
 *
 * 同步方法和非同步方法是否可以同时调用？
 * @author windo
 */
public class T08_Synchroized {
    public synchronized void t01(){
        System.out.println(Thread.currentThread().getName()+"t01 start...");
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"end");
    }

    public void t02(){
        try {
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"t02");
    }

    public static void main(String[] args) {
        T08_Synchroized t08_synchroized = new T08_Synchroized();
        /*new Thread(()->t08_synchroized.t01(),"t01").start();
        new Thread(()->t08_synchroized.t02(),"t02").start();*/
        //new Thread(t08_synchroized::t01,"t01").start();
        //new Thread(t08_synchroized::t02,"t02").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t08_synchroized.t02();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t08_synchroized.t01();
            }
        }).start();
        /**
         *
         */

    }
}
