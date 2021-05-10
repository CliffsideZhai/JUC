package com.cliffside.juc_Concurrent.BlockingQueue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author cliffside
 * @date 2020-11-17 20:33
 */
public class T09_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");//这个线程把这个东西put进入，但是没有离开，等有其他线程
        //把put的东西取走，才离开去执行其他的任务

        //strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


    }

}
