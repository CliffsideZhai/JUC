package com.cliffside.juc06_test;

import java.util.ArrayList;
import java.util.Collections;
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
 *
 * 用volatile可能在t1add之后但是size还没有更新的时候，t2线程加入，这是会出现不一致的情况
 *
 * volatile不建议去修饰引用变量，因为他修饰的引用变量里引用的资源如果修改，那么volatile并不会观察到他的引用变量发生了改变。
 * @author cliffside
 * @date 2020-11-16 9:09
 */
public class T02_WithoutVolatile {
    //volatile List lists = new ArrayList();

    volatile List lists = Collections.synchronizedList(new ArrayList<>());

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        synchronized (this){
            return lists.size();
        }
    }

    public static void main(String[] args) {
        T02_WithoutVolatile t01_withoutVolatile = new T02_WithoutVolatile();
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
            System.out.println("t2结束");
        },"t2").start();

    }


}
