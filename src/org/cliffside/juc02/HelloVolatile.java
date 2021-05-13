package org.cliffside.juc02;

/**
 * @author cliffside
 * @date 2021-05-10 21:49
 */
public class HelloVolatile {
    private static /*volatile*/ boolean running =true;

    private static void m(){
        System.out.println("m start");
        while (running){

            /**
             * 通过Sys print 的sync锁机制
             * 可能触发内存缓存同步刷新
             */
            System.out.println("hello");
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Thread(HelloVolatile::m,"t1").start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        running =true;
    }
}
