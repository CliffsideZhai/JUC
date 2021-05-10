package com.cliffside.juc10_ThreadPool.Pool;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2020-11-20 11:06
 *
 * Scheduled 定时任务线程池
 * 简单直接用TimeUnit
 * 复杂可以使用quartz cron
 *
 * 面试：假如一个闹钟服务，订阅服务人数特别多，10亿人次，怎么优化
 */
public class T10_ScheduledPool {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
        service.scheduleAtFixedRate(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, 0, 500, TimeUnit.MILLISECONDS);

    }


}
