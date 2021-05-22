package top.cliffside.MyCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1. Java线程与常用线程池体系
 * 2. ThreadPoolExecutor线程池启动源码原理
 * 3. ThreadPoolExecutor线程池提交任务执行过程源码原理
 * 4. ThreadPoolExecutor线程池关闭源码原理
 * 5. ScheduledThreadPoolExecutor启动源码原理
 * 6. ScheduledThreadPoolExecutor线程池提交任务执行过程源码原理
 * 7. ScheduledThreadPoolExecutor线程池关闭源码原理
 * 8. ForkJoinPool设计理念与普通线程池区别与联系
 * 9. ForkJoinPool核心数据结构
 * 10. ForkJoinTask、RecurisveAction、RecursiveTask、CountedCompleter任务区别
 * 11. ForkJoinPool提交任务执行过程源码与原理
 * 12. ForkJoinPool Fork/Join 过程源码与原理
 * 13. ForkJoinPool shutdown 过程源码与原理
 * 14. ForkJoinPool awaitTermination 过程源码与原理
 * 15. CompletionStage与Future原理
 * 16. Completion及其子类与ForkJoinTask原理
 * 17. CompletableFuture调用链原理
 * 18. CompletableFuture常用方法执行过程
 *  多线程实战
 * 1. 使用WebFlux增加系统整体吞吐量
 * 2. 使用并行流排序减少等待时间
 * 3. 使用AsyncEventBus事件机制解耦与异步执行增加系统吞吐量
 * 4. 使用Netty 构造Reactor机制
 * 5. 使用CompletableFuture调用链异步执行并回调，让出调度线程异步执行
 * 6. 使用ForkJoinPool大任务拆分多个子任务并行处理与合并
 * 7. 使用ScheduledThreadPoolExecutor异步定时或延时调度业务服务
 * 8. 使用RingBuffer并行处理日志，增加日志写入速度
 * 9. 使用ThreadPoolExecutor与Tomcat线程池搭配使用增加Tomcat吞吐量
 * @author cliffside
 * @date 2021-05-13 11:01
 */
public class MyCallable implements Callable<Integer> {
    /**
     * 1）创建Callable接口的实现类，并实现call()方法，
     * 该call()方法将作为线程执行体，并且有返回值。
     *        public interface Callable{
     * 　　      V call() throws Exception; }
     * 2）创建Callable实现类的实例，使用FutureTask类来包装Callable对象，
     * 该FutureTask对象封装了该Callable对象的call()方法的返回值。
     * （FutureTask是一个包装器，它通过接受Callable来创建，
     * 它同时实现了Future和Runnable接口）
     * 3）使用FutureTask对象作为Thread对象的target创建并启动新线程。
     * 4）调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable demo = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(demo);
        new Thread(ft ,"有返回值的线程").start();
        ft.get();
        System.out.println(ft.get());
    }
    @Override
    public Integer call() throws Exception
    {
        return 1;
    }

}
/**
 * 1、采用实现Runnable、Callable接口的方式创建多线程
 *
 *        优势是：
 *
 *        线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
 *
 *        在这种方式下，多个线程可以共享同一个target对象，
 *        所以非常适合多个相同线程来处理同一份资源的情况，
 *        从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
 *
 *        劣势是：
 *
 *        编程稍微复杂，如果要访问当前线程，则必须使用Thread.currentThread()方法。
 *
 * 2、使用继承Thread类的方式创建多线程
 *
 *       优势是：
 *
 *       编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，
 *       直接使用this即可获得当前线程。
 *
 *       劣势是：
 *
 *       线程类已经继承了Thread类，所以不能再继承其他父类。
 * 3、Runnable和Callable的区别
 *
 * (1) Callable规定（重写）的方法是call()，Runnable规定（重写）的方法是run()
 *
 * (2) Callable的任务执行后可返回值，而Runnable的任务是不能返回值的
 *
 * (3) call方法可以抛出异常，run方法不可以
 *
 * (4) 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。
 * 它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
 * 通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果
 */