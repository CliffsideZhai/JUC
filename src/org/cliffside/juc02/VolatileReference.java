package org.cliffside.juc02;

/**
 * @author cliffside
 * @date 2021-05-10 22:00
 * volatile 引用类型包括数组 只能保证引用本身的可见性，不能保证内部字段的可见性
 */
public class VolatileReference {
    private static class A{
        boolean running  =true;
        void m(){
            System.out.println("m start");
            while (running){ }
            System.out.println("m end");
        }

    }

    private volatile static A a = new A();
    public static void main(String[] args) throws InterruptedException {
        new Thread(a::m,"t1").start();

        Thread.sleep(1);
        a.running= false;
    }

}
