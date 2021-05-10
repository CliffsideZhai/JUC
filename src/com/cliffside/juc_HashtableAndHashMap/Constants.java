package com.cliffside.juc_HashtableAndHashMap;

/**
 * @author cliffside
 * @date 2020-11-17 15:55
 */
public class Constants {
    public static final int COUNT = 1000000;
    public static final int THREAD_COUNT = 100;


    /**
     * List(线程不安全的列表)--->Vector（本身方法是加锁的，但是调用方法之间的逻辑可能没有同步）
     * --> queue（为了高并发，多线程，尽量不考虑list和set。 ）
     *
     */
}
