package top.cliffside.WhatIsThread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author cliffside
 * @date 2021-05-22 15:02
 */
public class Piped {
    public static void main(String[] args) throws Exception {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                //写到管道pipe里
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }


    static class Print implements Runnable {
        private PipedReader in;
        public Print(PipedReader in) {
            this.in = in;
        }
        @Override
        public void run() {
            int receive = 0;
            try {
                //从pipe里读出
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException ex) {}
        }
    }

}
