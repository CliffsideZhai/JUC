package com.cliffside.juc10_ThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2020-11-18 10:39
 *
 * future存储将来执行的结果,callable执行的结果可以放到future
 * futureTask ：future + runnable
 */
public class P04_Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException, ExecutionException {

        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        }); //new Callable () { Integer call();}

        new Thread(task).start();

        System.out.println(task.get()); //


    }

}
