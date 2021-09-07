package source.Thread_Pool_Executor;

import com.cliffside.juc_HashtableAndHashMap.TestHashMap;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cliffside
 * @date 2021-09-05 14:56
 */
public class casDemo {
     static final Unsafe UNSAFE;
     static final long A_OFFSET;
     static final long COUNTER_OFFSET;
     static {
         try {
             Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
             UNSAFE = (Unsafe)theUnsafe.get(null);

             Class<casDemo> casDemoClass = casDemo.class;
             A_OFFSET = UNSAFE.staticFieldOffset(casDemoClass.getDeclaredField("a"));
             COUNTER_OFFSET = UNSAFE.staticFieldOffset(casDemoClass.getDeclaredField("counter"));
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }

     static volatile  int a =0;
     static volatile int counter = 1;

     public static void lock(){
         for (;;){

             if (UNSAFE.compareAndSwapInt(casDemo.class,COUNTER_OFFSET,1,0)){
                 break;
             }
             //Thread.yield();
         }
     }

     public static void unlock(){
         counter =1;
     }

     public static void inc(){
         lock();
         a++;
         unlock();
     }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        long l = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {

            executorService.execute(()->inc());

        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 -l);

        System.out.println(a);
    }
}
