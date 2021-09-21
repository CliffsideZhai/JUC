package source.Thread_Pool_Executor;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author cliffside
 * @date 2021-09-19 14:45
 */
public class MyScheduledThreadPoolExecutor {

    static class MyScheduledPool extends ScheduledThreadPoolExecutor{

        public MyScheduledPool(int corePoolSize) {
            super(corePoolSize);
        }

        @Override
        protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {


            return super.decorateTask(runnable, task);
        }
    }



    public static void main(String[] args) {

    }

}
