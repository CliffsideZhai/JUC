package com.cliffside.juc02_Synchronized;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * synchronized优化
 * 同步代码块中的语句越少越好
 * 比较test01 test02
 * @author cliffside
 * @date 2020-11-15 15:41
 */
public class T012_V03_Synchroized {
    int count =0 ;
    synchronized void test01(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count++;

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void  test02(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //在业务逻辑中只需要对这一段代码进行SYNC
        // ，因此不应该给整个方法上加锁，采用细粒度的锁，
        // 可以使线程争用时间变短，从而提高效率
        synchronized(this){
            count++;
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
