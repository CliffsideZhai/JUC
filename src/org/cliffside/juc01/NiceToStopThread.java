package org.cliffside.juc01;

/**
 * @author cliffside
 * @date 2021-05-10 21:39
 * 不依靠特定数据
 */
public class NiceToStopThread {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (running){
                System.out.println("go go go");
                try {
                    Thread.sleep(1111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = false;
    }
}
