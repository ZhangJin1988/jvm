package com.jvm.study3;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class StackDeepTest {



    /**
     * 没有参数 调用深度
     *deep of calling = 3308
     java.lang.StackOverflowError
     at com.jvm.study3.StackDeepTest.recursion(StackDeepTest.java:18)
     at com.jvm.study3.StackDeepTest.recursion(StackDeepTest.java:20)
     at com.jvm.study3.StackDeepTest.recursion(StackDeepTest.java:20)

     *
     *
     * -Xss256K
     deep of calling = 577

     -Xss512K
     deep of calling = 1487


     增大栈内存的大小  可以增加递归调用的深度
     */
    private static int count = 0;

    public static void recursion(long a, long b, long c) {
        long e = 1, f = 2, g = 3, h = 4, i = 5, k = 6, q = 7, x = 8, y = 9, z = 10;
        count++;
        recursion(a, b, c);
    }

    public static void main(String args[]) {
        try {
            recursion(0L, 0L, 0L);
        } catch (Throwable e) {
            System.out.println("deep of calling = " + count);
            e.printStackTrace();
        }
    }
}