package top.cliffside.MyThreadPool;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @author cliffside
 * @date 2021-05-13 11:10
 * java线程池的体系
 * 1.Executor：线程池顶级接口；
 * 2.ExecutorService：线程池次级接口，对Executor做了一些扩展，增加了一些功能；
 * 3.ScheduledExecutorService：对ExecutorService做了一些扩展，增加一些定时任务相关的功能；
 * 4.AbstractExecutorService：抽象类，运用模板方法设计模式实现了一部分方法；
 * 5.ThreadPoolExecutor：普通线程池类，包含最基本的一些线程池操作相关的方法实现；
 * 6.ScheduledThreadPoolExecutor：定时任务线程池类，用于实现定时任务相关功能；
 * 7.ForkJoinPool：新型线程池类，java7中新增的线程池类，基于工作窃取理论实现，运用于大任务拆小任务，任务无限多的场景；
 * 8.Excutors：线程池工具类，定义了一些快速实现线程池的方法
 */
public class MyThreadPool {
    public Executor executor ;
    public ExecutorService service;
    public AbstractExecutorService abstractExecutorService;
}
