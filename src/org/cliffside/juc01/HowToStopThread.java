package org.cliffside.juc01;

/**
 * @author cliffside
 * @date 2021-05-10 21:24
 */
public class HowToStopThread {



    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (true){
                System.out.println("go go go");
                try {
                    Thread.sleep(1111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread.sleep(1000);
        //thread.stop();

        thread.suspend();

        Thread.sleep(222);
        thread.resume();
    }
}
