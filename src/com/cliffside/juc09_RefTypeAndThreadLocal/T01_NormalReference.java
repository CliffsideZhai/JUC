package com.cliffside.juc09_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @author cliffside
 * @date 2020-11-17 13:34
 */
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();

        m = null;
        System.gc();
        System.in.read();
    }
}
