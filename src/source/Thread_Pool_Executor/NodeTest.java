package source.Thread_Pool_Executor;

import top.cliffside.ThreadPool.ThreadPool;

import java.util.concurrent.*;

/**
 * @author cliffside
 * @date 2021-09-11 15:33
 */
public class NodeTest {

    static class MyThreadPool extends ThreadPoolExecutor{


        public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {

            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);

            int i = 1/0;
        }
    }

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(
                1, 1, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>()
                , new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("有异常");
                    }
                });
                return  thread;
            }
        },new ThreadPoolExecutor.CallerRunsPolicy());
        myThreadPool.execute(() ->{System.out.println(1);});
    }
}
