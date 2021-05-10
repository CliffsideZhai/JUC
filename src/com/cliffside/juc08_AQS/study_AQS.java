package com.cliffside.juc08_AQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cliffside
 * @date 2020-11-16 13:52
 */
public class study_AQS {
    private static  int i =0;
    public static void main(String[] args) {

        ReentrantLock lock=  new ReentrantLock();
        lock.lock();


    }

}
