package com.cliffside.juc_Concurrent;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cliffside
 * @date 2020-11-17 19:34
 */
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        List<String> lists =//应用于读的多，写的少的情况
                //new ArrayList<>(); //这个会出并发问题！因为arrayList没有锁
                //new Vector();读写都加锁
                new CopyOnWriteArrayList<>();//写时复制，写时加锁，读的时候不加锁
        Random r = new Random();
        Thread[] ths = new Thread[100];

        for(int i=0; i<ths.length; i++) {
            Runnable task = new Runnable() {

                @Override
                public void run() {
                    for(int i=0; i<1000; i++) {
                        lists.add("a" + r.nextInt(10000));
                    }
                }

            };
            ths[i] = new Thread(task);
        }


        runAndComputeTime(ths);

        System.out.println(lists.size());
    }

    static void runAndComputeTime(Thread[] ths) {
        long s1 = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);

    }

    //实现加锁的list
    List<String> strs = new ArrayList<>();
    List<String> strsSync = Collections.synchronizedList(strs);


}
