package source.Thread_Pool_Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2021-09-19 15:27
 */
public class BetterDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

        executor.schedule(()->executorService.execute(()->{
            System.out.println("hello");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }),1, TimeUnit.SECONDS);
        executor.schedule(()->executorService.execute(()->{
            System.out.println("hello");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }),1, TimeUnit.SECONDS);
        executor.schedule(()->executorService.execute(()->{
            System.out.println("hello");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }),1, TimeUnit.SECONDS);
        executor.schedule(()->executorService.execute(()->{
            System.out.println("hello");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }),1, TimeUnit.SECONDS);
        executor.schedule(()->executorService.execute(()->{
            System.out.println("hello");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }),1, TimeUnit.SECONDS);
    }
}
