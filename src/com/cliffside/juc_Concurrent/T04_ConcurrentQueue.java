package com.cliffside.juc_Concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author cliffside
 * @date 2020-11-17 20:07
 */
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for(int i=0; i<10; i++) {
            strs.offer("a" + i);  //add
        }

        System.out.println(strs);

        System.out.println(strs.size());

        System.out.println(strs.poll());
        System.out.println(strs.size());

        System.out.println(strs.peek());
        System.out.println(strs.size());

        //˫˶Deque
    }

}
