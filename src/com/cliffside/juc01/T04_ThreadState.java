package com.cliffside.juc01;

public class T04_ThreadState {

    /**
     *6个状态定义: java.lang.Thread.State
     * 　　New: 尚未启动的线程的线程状态。　
     * 　Runnable: 可运行线程的线程状态，等待CPU调度————————由线程调度器执行。　（内部有两个状态，一个Ready就绪状态 ，一个Running状态）
     * 　Blocked: 线程阻塞等待监视器锁定的线程状态。　　处于synchronized同步代码块或方法中被阻塞。　
     * 　Waiting: 等待线程的线程状态。下列不带超时的方式:　　Object.wait、Thread.join、 LockSupport.park　。当调用Object.notify()  Object.notifyAll()  LockSupport.unpark()  方法时，充重新进入Runnable状态
     * 　Timed Waiting:具有指定等待时间的等待线程的线程状态。下 列带超时的方式:　　Thread.sleep、0bject.wait、 Thread.join、 LockSupport.parkNanos、 LockSupport.parkUntil　时间结束后们重新进入Runnable状态
     *
     * 　Terminated: 终止线程的线程状态。线程正常完成执行或者出现异常。
     *
     *
     */
}
