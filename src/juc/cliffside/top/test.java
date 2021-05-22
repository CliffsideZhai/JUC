package juc.cliffside.top;

/**
 * @author cliffside
 * @date 2021-05-13 19:35
 */
public class test {
        int a = 0;
        boolean flag = false;
        public void writer() {
            a = 1; // 1
            flag = true; // 2
        }
        public void reader() {
            if (flag) { // 3
                int i = a * a; // 4
                System.out.println(i);
            }
        }
    public static void main(String[] args) {
        test test = new test();

        Thread thread1 = new Thread(() -> {
            test.writer();
        });
        Thread thread2 = new Thread(() -> {
            test.reader();
        });
        thread1.start();
        thread2.start();
    }

}
