package org.cliffside.juc01;

/**
 * @author cliffside
 * @date 2021-05-10 21:41
 */
public class BestToStopThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()){

            }
            System.out.println("go go go");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
