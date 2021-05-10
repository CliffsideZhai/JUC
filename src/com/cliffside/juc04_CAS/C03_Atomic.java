package com.cliffside.juc04_CAS;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author cliffside
 * @date 2020-11-15 17:16
 */
public class C03_Atomic {
    Long count1 = 0L;
    AtomicLong count2= new AtomicLong(0L);
    LongAdder count3 = new LongAdder();

}
