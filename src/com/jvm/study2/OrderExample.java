package com.jvm.study2;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class OrderExample {


    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
        System.out.println("writer中a=" + a);
    }

    public void reader() {
        if (flag) {
            int i =  a +1;
        }
        System.out.println("reader中a = " + a);
    }


    public static void main(String[] args) {

        final OrderExample orderExample = new OrderExample();
        new Thread(new Runnable() {
            @Override
            public void run() {
                orderExample.writer();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                orderExample.reader();
            }
        }).start();


    }
}
