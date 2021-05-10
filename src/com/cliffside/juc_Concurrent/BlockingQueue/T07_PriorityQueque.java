package com.cliffside.juc_Concurrent.BlockingQueue;

import java.util.PriorityQueue;

/**
 * @author cliffside
 * @date 2020-11-17 20:25
 *
 * 本质是按照树的结构来实现，会进行排序
 */
public class T07_PriorityQueque {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }

}
