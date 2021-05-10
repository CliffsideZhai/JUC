package com.cliffside.juc02_Synchronized;

/**
 *synchronized关键字
 *
 * 不可以锁String常量 Integer long。别用基本数据类型
 *为某个对象加锁
 * @author windo
 *
 * 底层实现
 * JDK早期：重量级---OS  效率非常低
 * 后来改进
 * 锁的升级状态
 * 1、无锁
 * 2、锁升级的概念：当第一个线程A拿到sync(object)时，mark word，只会记录这个线程ID（偏向锁）
 * 3、如果此时有线程争用：升级为自旋锁，线程B发现A拿到了锁，那么B在原地默认自旋10次（占用CPU但是不访问OS，在用户态，不经过内核态）【一般执行时间短，线程数量少的时候使用自旋锁】
 * 4、如果还得不到这把锁：升级为重量级锁，————去OS申请资源（进入等待队列，即会经过内核态，将不会占用CPU）
 * 只能升级不能降级
 */
public class T05_Synchroized {
    private int count = 10;
    private Object o = new Object();

    public void test(){
        //任何线程要执行锁内的代码，必须拿到o的锁
        //在JVM中对如何进行synchronized操作时没有规范的
        //而hotspot对于synchronized操作是，在一个java堆里的对象中的64位，拿出其中前两位来标记（mark word）
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }
}
