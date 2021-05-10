package com.cliffside.juc09_RefTypeAndThreadLocal;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/*** 弱引用遭到gc就会回收
 *

 * @author cliffside
 * @date 2020-11-17 14:04
 */
public class T03_WeakReference {
    public static void main(String[] args) {
        //
        WeakReference<M> mWeakReference = new WeakReference<>(new M());

        System.out.println(mWeakReference.get());
        System.gc();


        System.out.println(mWeakReference.get());

        ThreadLocal<M> local = new ThreadLocal<>();
        //local指向一个M--ThreadLocal，是强引用
        local.set(new M());
        /**
         * ThreadLocal底层是使用一个map<k,v>来实现
         * 这里K里的this，其实是通过弱引用来指向当前ThreadLocal
         *
         * 当这个ThreadLocal不被local使用的时候，这个map会一直存在
         * 但理想的是这里的k可以在当前ThreadLocal没有引用的时候也被回收。
         * 否则会造成内存泄漏，这就是为什么使用弱引用。
         *
         * 但是这时虽然这个弱引用也被回收了，但是这个k现在确实null了，他依然存在，因此
         * 还会有内存泄漏的可能，因此我们其实更希望的是每次用完之后，手动remove
         */
        local.remove();

    }

}
