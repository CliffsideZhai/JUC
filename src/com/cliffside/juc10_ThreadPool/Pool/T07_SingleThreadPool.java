package com.cliffside.juc10_ThreadPool.Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cliffside
 * @date 2020-11-20 10:38
 * Executors 可以看作是线程池的工厂
 *
 * 一个线程的线程池可以保证任务的顺序执行
 *
 * 为什么要有单线程的线程池
 * 1、 线程池有任务队列
 * 2、 生命周期管理
 *
 */
public class T07_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0; i<5; i++) {
            final int j = i;
            service.execute(()->{

                System.out.println(j + " " + Thread.currentThread().getName());
            });
        }

    }

}
