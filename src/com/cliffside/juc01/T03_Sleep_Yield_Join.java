package com.cliffside.juc01;

import java.util.concurrent.TimeUnit;

public class T03_Sleep_Yield_Join {
    public static void main(String[] args) {
        //
        // testSleep();
        //testYield();
        testJoin();
    }

    //睡200毫秒
    static void testSleep(){
        new Thread(()->{
            for (int i= 0 ;i<100;i++){
                System.out.println("testSleep"+i);
                try {
                    Thread.sleep(200);
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //让线程很谦让的退出一会儿。进入等待队列。把cpu让出来一下，重新进入就绪状态
    //如果没有线程，那么这个线程会继续执行

    static void testYield(){
        new Thread(()->{
            for (int i=0;i <100;i++){
                System.out.println("testYield"+i);
                if (i%10 ==0){
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i=0;i<100;i++){
                System.out.println("-----------第二个线程，"+i);
                if (i%10 ==0){
                    Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin(){
        Thread t1 = new Thread(()->{
            System.out.println("this is t1");
           for (int i=0;i<100;i++){
               System.out.println("testJoin"+i);
               try {
                   Thread.sleep(500);

               }catch (Exception e ){
                   e.printStackTrace();
               }
           }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();//当t2执行的时候，执行到t1join 的方法时，t2线程暂停，由t1先执行，当他
                //t1线程执行完毕后，t2继续执行。因此当由t1 t2 t3三个线程要按照顺序执行时，
                ///可以让t1里调用t2join，t2线程里调用t3join
                System.out.println("this is t2");
            }catch (Exception e ){
                e.printStackTrace();
            }
        });

        t2.start();
    }
}
