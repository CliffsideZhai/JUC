package com.cliffside.juc06_test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 曾经的面试题：（淘宝）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * 分析下面这个程序，能完成这个功能吗？
 * 不可以，
 * 1、线程不同步
 * 2、线程之间不可见
 * @author cliffside
 * @date 2020-11-16 9:09
 */
public class T01_WithoutVolatile {
    List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        synchronized (this){
            return lists.size();
        }
    }

    public static void main(String[] args) {
        T01_WithoutVolatile t01_withoutVolatile = new T01_WithoutVolatile();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                t01_withoutVolatile.add(new Object());
                System.out.println("add"+i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if (t01_withoutVolatile.size() == 5){
                    break;
                }
            }
        },"t2").start();

    }


}
