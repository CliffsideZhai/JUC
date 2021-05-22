package top.cliffside.SyncLock;

/**
 * @author cliffside
 * @date 2021-05-18 18:47
 */
public class Example {
    class MonitorExample {
        int a = 0;
        public synchronized void writer() { // 1
            a++; // 2
        } // 3
        public synchronized void reader() { // 4
            int i = a; // 5
        } // 6
    }

}
