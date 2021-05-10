package com.cliffside.juc10_ThreadPool.Pool;

import java.util.concurrent.*;

/**
 * @author cliffside
 * @date 2020-11-20 13:07
 */
public class T11_NewRejectedHandler {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(),new NewRejectedExecution());
    }

    static class NewRejectedExecution implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            //log("r rejected")
            //save r kafka mysql redis
            //try 3 times
            if(executor.getQueue().size() < 10000) {
                //try put again();
            }

        }
    }

}
