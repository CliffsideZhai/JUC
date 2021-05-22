package org.cliffside.juc03;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cliffside
 * @date 2021-05-14 9:52
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ArrayList<Callable<Integer>> callableArrayList = Lists.newArrayList(
                new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println(1);
                        return null;
                    }
                }, new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {

                        try {
                            Thread.sleep(111);
                            System.out.println(2);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        return null;
                    }
                });
        /**
         * 多个线程同时执行完毕，只返回第一个结果
         * 至少执行一个，线程池中先将第一个任务丢进去执行
         * 如果第一个执行的时候，放入第二个任务
         * 最后会返回第一个任务的值
         *
         * 在底层，只要抛出异常就终止，因此在sleep的过程中任务一完成，
         * ECS最终cancel了所有剩余任务抛出了终端异常
         * 所以任务二不会执行
         */
        executorService.invokeAny(callableArrayList);
    }
}
