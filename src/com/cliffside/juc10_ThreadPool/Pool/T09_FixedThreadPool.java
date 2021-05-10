package com.cliffside.juc10_ThreadPool.Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author cliffside
 * @date 2020-11-20 10:54
 *
 * 并发Concurrent 和 并行 parallel
 *      |                 |
 *    任务提交             任务执行
 *    并行是并发的子集
 *
 * 什么时候用cacheThreadPool 或 FixedThreadPool
 *  前者任务量忽高忽低
 *  后者任务量比较平稳
 */
public class T09_FixedThreadPool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        getPrime(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        final int cpuCoreNum = 4;

        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);

        MyTask t1 = new MyTask(1, 80000); //1-5 5-10 10-15 15-20
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static class MyTask implements Callable<List<Integer>> {
        int startPos, endPos;

        MyTask(int s, int e) {
            this.startPos = s;
            this.endPos = e;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos, endPos);
            return r;
        }

    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for(int i=start; i<=end; i++) {
            if(isPrime(i)) {
                results.add(i);
            }
        }

        return results;
    }

}
