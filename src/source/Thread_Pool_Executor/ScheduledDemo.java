package source.Thread_Pool_Executor;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2021-09-12 15:53
 */
public class ScheduledDemo {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
//        executor.schedule(()->{
//            System.out.println("hello world");
//        },1, TimeUnit.SECONDS);


        //从任务开始执行的时间起始，不包含任务本身的执行时间
        executor.scheduleAtFixedRate(()->{
            System.out.println(new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },0,2,TimeUnit.SECONDS);


        //从任务执行的时间结束之后，延迟一定时间
        executor.scheduleWithFixedDelay(()->{
            System.out.println(new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,2,TimeUnit.SECONDS);

    }



}
