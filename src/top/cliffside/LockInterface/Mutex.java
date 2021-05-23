package top.cliffside.LockInterface;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**独占锁Mutex是一个自定义同步组件，它在同一时刻只允许一个线程占有
 * 锁。Mutex中定义了一个静态内部类，该内部类继承了同步器并实现了独占式获取和释放同步
 * 状态。在tryAcquire(int acquires)方法中，如果经过CAS设置成功（同步状态设置为1），则代表获
 * 取了同步状态，而在tryRelease(int releases)方法中只是将同步状态重置为0。用户使用Mutex时
 * 并不会直接和内部同步器的实现打交道，而是调用Mutex提供的方法，在Mutex的实现中，以获
 * 取锁的lock()方法为例，只需要在方法实现中调用同步器的模板方法acquire(int args)即可，当前线程调用该方法获取同步状态失败后会被加入到同步队列中等待，这样就大大降低了实现
 * 一个可靠自定义同步组件的门槛
 * @author cliffside
 * @date 2021-05-23 16:05
 */
public class Mutex implements Lock {

    // 静态内部类，自定义同步器
    private static class SyncLock extends AbstractQueuedSynchronizer{
        // 是否处于占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
        // 当状态为0的时候获取锁
        @Override
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 释放锁，将状态设置为0
        @Override
        protected boolean tryRelease(int releases) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        // 返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final SyncLock lock  = new SyncLock();
    @Override
    public void lock() {
        lock.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        lock.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return lock.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return lock.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        lock.release(1);
    }

    @Override
    public Condition newCondition() {
        return lock.newCondition();
    }
}
