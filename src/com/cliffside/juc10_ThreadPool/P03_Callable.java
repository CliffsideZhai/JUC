package com.cliffside.juc10_ThreadPool;

import java.util.concurrent.*;

/**
 * @author cliffside
 * @date 2020-11-18 10:33
 *
 * Callable和runnalbe一样，也可以是一个线程去运行它
 * 可以有返回值
 */
public class P03_Callable implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable() {
            @Override
            public String call() throws Exception {
                return "Hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();

        Future<String> future = service.submit(c); //异步

        System.out.println(future.get());//阻塞

        service.shutdown();
    }


}
