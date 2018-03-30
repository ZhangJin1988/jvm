package com.jvm.study4;

/**
 * Created by zhangjin on 2018/3/30.
 */

public class PrintThreadTest extends Thread {
    public static class PrintThread extends Thread {
        public static final long starttime = System.currentTimeMillis();

        @Override
        public void run() {
            try {
                while (true) {
                    long t = System.currentTimeMillis() - starttime;
                    System.out.println("time:" + t);
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        }
    }


    public static void main(String[] args) {

        new PrintThread().run();
    }

}

