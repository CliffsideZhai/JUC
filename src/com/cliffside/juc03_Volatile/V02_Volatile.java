package com.cliffside.juc03_Volatile;

import javax.swing.*;

/**
 * 双重检查的单例模式
 *
 * 为什么要加volatile，
 * 因为可能会出现指令重排序
 *
 *
 * 一个对象的加载从申请内存——————>成员变量初始化。调用初始化方法————————>把值赋值给instance
 * @author cliffside
 * @date 2020-11-15 15:15
 */


public class V02_Volatile {
    private static volatile V02_Volatile INSTANCE;
    private V02_Volatile(){

    }

    public static V02_Volatile getInstance(){
        if (INSTANCE == null){
            //双重检查保证了线程的安全性
            synchronized (V02_Volatile.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE =  new V02_Volatile();
                }
            }
        }
        return INSTANCE;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i =0;i<100;i++){
            new Thread(()->{
                System.out.println(V02_Volatile.getInstance().hashCode());
            }).start();
        }
    }
}
