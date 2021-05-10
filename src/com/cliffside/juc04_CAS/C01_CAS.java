package com.cliffside.juc04_CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS（乐观锁）:compare and set cas(Value,Expected,NewValue)
 * 只有当期望值和value一致的时候，才会用newValue更新value
 * 使CPU原语支持，是CPU指令级别的执行，之间不可被打断。
 * 无锁优化，其实还是自旋
 * 凡是Atomic开头的都是使用CAS来实现线程安全
 * @author cliffside
 * @date 2020-11-15 15:59
 *
 * ABA问题
 * 在CAS操作中，有一个线程，先把value从A变成B再变成A，就是ABA问题（基础类型无所谓,引用类型——>前女友复合）
 * 对于这种问题，就是每次更改的时候加版本号version。用AtomicStampedReference就是原子时间戳类
 */
public class C01_CAS {

    /*volatile*/  //int count = 0;
    AtomicInteger count  = new AtomicInteger(0);
    void test(){
        for (int i = 0;i<100;i++){

            count.incrementAndGet();//count++
        }
    }

    public static void main(String[] args) {
        C01_CAS c01_cas = new C01_CAS();

        List<Thread> threads = new ArrayList<Thread>();

        for (int i= 0;i<100;i++){
            threads.add(new Thread(c01_cas::test,"thread"+i));
        }


        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(c01_cas.count);
    }
}
