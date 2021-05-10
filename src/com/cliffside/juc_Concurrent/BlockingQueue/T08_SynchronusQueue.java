package com.cliffside.juc_Concurrent.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author cliffside
 * @date 2020-11-17 20:28
 * 自己实现线程池常用
 *
 * 这个容量为0
 */

public class T08_SynchronusQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //阻塞等待消费者消费
        //strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }

}
