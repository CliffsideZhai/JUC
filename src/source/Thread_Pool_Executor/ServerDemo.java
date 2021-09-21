package source.Thread_Pool_Executor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2021-09-19 16:50
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(()->{
            System.out.println("hello world");
        });

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.DAYS);
    }
}
