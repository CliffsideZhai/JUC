package top.cliffside.VolatileLock;

/**
 * @author cliffside
 * @date 2021-05-18 15:44
 */
public class Lock {
    class VolatileExample {
        int a = 0;
        volatile boolean flag = false;
        public void writer() {
            a = 1; // 1
            flag = true; // 2
        }
        public void reader() {
            if (flag) { // 3
                int i = a; // 4
            }
        }
    }

}
/**
 * 假设线程A执行writer()方法之后，线程B执行reader()方法。根据happens-before规则，这个
 * 过程建立的happens-before关系可以分为3类：
 * 1）根据程序次序规则，1 happens-before 2;3 happens-before 4。
 * 2）根据volatile规则，2 happens-before 3。
 * 3）根据happens-before的传递性规则，1 happens-before 4。
 * 上述happens-before关系的图形化表现形式如下
 *
 * 这里A线程写一个volatile变量后，B线程读同一个volatile变量。A线程在写volatile变量之
 * 前所有可见的共享变量，在B线程读同一个volatile变量后，将立即变得对B线程可见
 */