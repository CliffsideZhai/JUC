package com.cliffside.juc09_RefTypeAndThreadLocal;

/**
 * @author cliffside
 * @date 2020-11-17 13:30
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("fffff");
    }
}
