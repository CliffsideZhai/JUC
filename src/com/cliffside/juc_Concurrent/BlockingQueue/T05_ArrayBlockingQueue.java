package com.cliffside.juc_Concurrent.BlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2020-11-17 20:17
 */
public class T05_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        //strs.put("aaa"); //满了就会等待，程序阻塞
        //strs.add("aaa");
        //strs.offer("aaa");
        strs.offer("aaa", 1, TimeUnit.SECONDS);

        System.out.println(strs);
    }

}
