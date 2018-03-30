package com.jvm.study2;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class OnStackTest {

    /**
     * 1  -server -Xmx10m -Xms10m
     -XX:+DoEscapeAnalysis -XX:+PrintGC

     栈上分配 会快
     输出结果
     [GC (Allocation Failure)  2048K->528K(9728K), 0.0011403 secs]
     [GC (Allocation Failure)  2576K->480K(9728K), 0.0012643 secs]
     7


     2 -server -Xmx10m -Xms10m
     -XX:-DoEscapeAnalysis -XX:+PrintGC
     非栈上分配 会慢


     输出结果
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0004171 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003052 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0004110 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003453 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003417 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003070 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003140 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003007 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0002704 secs]
     [GC (Allocation Failure)  2445K->397K(9728K), 0.0003917 secs]
     888

     */


        public static void alloc(){
            byte[] b=new byte[2];
            b[0]=1;
        }
        public static void main(String[] args) {
            long b=System.currentTimeMillis();
            for(int i=0;i<100000000;i++){
                alloc();
            }
            long e=System.currentTimeMillis();
            System.out.println(e-b);
        }

}
