package com.cliffside.juc02_Synchronized;

public class T06_Synchroized {
    private int count = 10;
    private static int number = 10;

    public void test(){
        synchronized (this){
            //锁定当前对象，那么就可以写成test02形式
            count--;
            System.out.println(Thread.currentThread().getName()+"count"+count);
        }
    }

    public synchronized void test02(){
        count--;
        System.out.println(Thread.currentThread().getName()+"count"+count);
    }

    public synchronized static void test03(){
        //static方法是没有this对象的，所以，这里的synchronized操作相当于，synchronized(T06_Synchroized.class),一般来说这个.class是单例的
        number--;
        System.out.println(Thread.currentThread().getName()+"number"+number);
    }
}
