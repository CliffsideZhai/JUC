package top.cliffside.SyncLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cliffside
 * @date 2021-05-18 22:53
 */
public class ReentrantLockExample {
    class Example {
        int a = 0;
        ReentrantLock lock = new ReentrantLock();
        public void writer() {
            lock.lock(); // 获取锁
            try {
                a++;
            }finally {
                lock.unlock(); // 释放锁
            }
        }
        public void reader () {
            lock.lock(); // 获取锁
            try {
                int i = a;
            }finally {
                lock.unlock(); // 释放锁
            }
        }
    }
}
