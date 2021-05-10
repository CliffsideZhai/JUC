package com.cliffside.juc_Concurrent;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author cliffside
 * @date 2020-11-17 19:26
 */
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();//这里底层使用的是CAS操作
        //Map<String, String> map = new ConcurrentSkipListMap<>();
        // 跳表在列表之上，把其中关键元素单独拉出来，再重新弄一些列表。߲高并发并排序
        //TreeMap使用的是红黑树，为什么没有concurrentTreeMap？因为如对于红黑树来说，底层用CAS实现太复杂了

        //Map<String, String> map = new Hashtable<>();
        //Map<String, String> map = new HashMap<>(); //Collections.synchronizedXXX
        //TreeMap
        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for(int i=0; i<ths.length; i++) {
            ths[i] = new Thread(()->{
                for(int j=0; j<10000; j++) map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(map.size());

    }

}
