package com.cliffside.juc02_Synchronized;

/**
 * 一个小程序，
 * 当没有加锁的时候，
 * 多个线程同时执行run方法，有可能前一个方法的输出还没有执行，
 * 第二个线程就已经count--了，导致输出直接从原本输出9到输出8
 * 线程的执行顺序也没有办法保证
 *
 *
 * 加了synchronized 既保证了原子性又保证了可见性
 * @author windo
 */
public class T07_Synchroized implements Runnable {

    private  int count = 10;
    @Override
    public /*synchronized*/ void run(){
        count--;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }

    public static void main(String[] args) {
        T07_Synchroized t07_synchroized = new T07_Synchroized();
        for (int i = 0;i<10;i++){
            new Thread(t07_synchroized,"Thread"+i).start();
        }
    }
}
