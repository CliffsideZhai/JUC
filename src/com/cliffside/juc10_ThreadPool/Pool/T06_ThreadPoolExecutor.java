package com.cliffside.juc10_ThreadPool.Pool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *java 线程池分为
 * ThreadPoolExecutor
 * ForkJoinPool:分解汇总任务，用很少的线程可以执行很多的任务（子任务），TPE做不到先执行子任务，CPU密集型
 * @author cliffside
 * @date 2020-11-19 22:00
 *
 * 如何自定义一个线程池
 */
public class T06_ThreadPoolExecutor {
    static class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }

    /**
     * 线程池维护两个集合，一个是线程的集合，一个是任务的集合
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 8; i++) {
            tpe.execute(new Task(i));
        }

        System.out.println(tpe.getQueue());

        tpe.execute(new Task(100));

        System.out.println(tpe.getQueue());

        tpe.shutdown();
    }


}
