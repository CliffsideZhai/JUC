package juc.cliffside.VolatilePlay;

import jdk.internal.vm.annotation.Contended;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author cliffside
 * @date 2021-05-11 17:23
 * LinkedTransferQueue是LinkedBlockingQueue、
 * SynchronousQueue（公平模式）、
 * ConcurrentLinkedQueue三者的集合体，它综合了这三者的方法，并且提供了更加高效的实现方式。
 *
 * LinkedTransferQueue实现了TransferQueue接口，
 * 而TransferQueue接口是继承自BlockingQueue的，
 * 所以LinkedTransferQueue也是一个阻塞队列。
 */
public class juc01_LinkedTransferQueue {
    /**
     * 使用追加字节的方式来以哦欧化队列出队入队的性能
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedTransferQueue<Object> objects = new LinkedTransferQueue<>();

    }

    /**
     * 保证变量只存在一个cache line中
     */
    private static class T{
        @Contended
        public long x =0L;
    }
}
