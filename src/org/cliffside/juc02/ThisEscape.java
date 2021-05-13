package org.cliffside.juc02;

/**
 * @author cliffside
 * @date 2021-05-11 19:51
 */
public class ThisEscape {
    private int num =8;
    public static void main(String[] args) {
        Object o = new Object();

        ThisEscape thisEscape = new ThisEscape();
    }
    public ThisEscape(){
        new Thread(()->{
            System.out.println(this.num);
        }).start();
    }
}
