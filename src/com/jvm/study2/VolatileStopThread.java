package com.jvm.study2;

/**
 * Created by zhangjin on 2018/3/30.
 */


public class VolatileStopThread extends Thread{
    /**
     * 没有valatile 无法停止线程
     */
    private  boolean stop = false;
//    private volatile boolean stop = false;
    public void stopMe(){
        stop=true;
    }

    public void run(){
        int i=0;
        while(!stop){
            i++;
        }
        System.out.println("Stop thread");
    }

    public static void main(String args[]) throws InterruptedException{
        VolatileStopThread t=new VolatileStopThread();
        t.start();
        Thread.sleep(1000);
        t.stopMe();
        Thread.sleep(1000);
    }
}
