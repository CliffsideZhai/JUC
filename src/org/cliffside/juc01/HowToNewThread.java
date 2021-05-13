package org.cliffside.juc01;

import java.util.concurrent.*;

/**
 * @author cliffside
 * @date 2021-05-10 20:37
 */
public class HowToNewThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello my thread");
        }
    }

    static class MyRun implements Runnable{

        @Override
        public void run() {
            System.out.println("hello my runnable");
        }
    }

    static class MyCall implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("hello mycall");
            return "success";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{

            System.out.println("hello lambda");
        }).start();

        Thread thread = new Thread(new FutureTask<String>(new MyCall()));
        thread.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println("hello Threadpool");
            }
        );

        /**
         * 异步执行
         */
        Future<String> submit = executorService.submit(new MyCall());
        //阻塞执行
        System.out.println("执行call方法");
        String s = submit.get();
        System.out.println("阻塞执行future"+s);
        executorService.shutdown();
    }
}
