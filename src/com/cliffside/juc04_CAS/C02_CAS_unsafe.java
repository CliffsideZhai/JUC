package com.cliffside.juc04_CAS;

/**
 * @author cliffside
 * @date 2020-11-15 16:50
 */
public class C02_CAS_unsafe {
    /**
     * 单例模式，想要用，只能用getUnsafe.11.0底层的unsafe使用的是weakCompareAndSet
     *
     * Unsafe直接操作Java虚拟机的内存
     * 所有atomic开头的类，都是通过unsafe里的compareAndSet 和compareAndSwap来操作
     * 几乎等同于c（malloc freee） 和c艹（new delete）的指针
     *
     */

/**
 * public final class Unsafe {
 *
 *     private static native void registerNatives();
 *     static {
 *         registerNatives();
 *     }
 *
 *     private Unsafe() {}
 *
 *     private static final Unsafe theUnsafe = new Unsafe();
 */
}
