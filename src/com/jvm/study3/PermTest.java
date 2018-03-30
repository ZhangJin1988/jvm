package com.jvm.study3;

import java.util.HashMap;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class PermTest {

    /**
     * -XX:PermSize=1m  -XX:MaxPermSize=2m  -XX:+PrintGCDetails
     * jdk1.8中 一直没有内存溢出
     *   1.8没有永久区的概率 多次执行后的GC日志 待分析
     *  几乎没有变化
     *
     * 99998
     99999
     Heap
     PSYoungGen      total 76288K, used 40381K [0x000000076ab00000, 0x0000000770000000, 0x00000007c0000000)
     eden space 65536K, 59% used [0x000000076ab00000,0x000000076d1458c0,0x000000076eb00000)
     from space 10752K, 11% used [0x000000076eb00000,0x000000076ec29d00,0x000000076f580000)
     to   space 10752K, 0% used [0x000000076f580000,0x000000076f580000,0x0000000770000000)
     ParOldGen       total 175104K, used 8K [0x00000006c0000000, 0x00000006cab00000, 0x000000076ab00000)
     object space 175104K, 0% used [0x00000006c0000000,0x00000006c0002000,0x00000006cab00000)
     Metaspace       used 3863K, capacity 5156K, committed 5376K, reserved 1056768K
     class space    used 409K, capacity 458K, committed 512K, reserved 1048576K


     PSYoungGen      total 76288K, used 40328K [0x000000076ab00000, 0x0000000770000000, 0x00000007c0000000)
     eden space 65536K, 59% used [0x000000076ab00000,0x000000076d145998,0x000000076eb00000)
     from space 10752K, 10% used [0x000000076eb00000,0x000000076ec1c8b8,0x000000076f580000)
     to   space 10752K, 0% used [0x000000076f580000,0x000000076f580000,0x0000000770000000)
     ParOldGen       total 175104K, used 8K [0x00000006c0000000, 0x00000006cab00000, 0x000000076ab00000)
     object space 175104K, 0% used [0x00000006c0000000,0x00000006c0002000,0x00000006cab00000)
     Metaspace       used 3866K, capacity 5156K, committed 5376K, reserved 1056768K
     class space    used 409K, capacity 458K, committed 512K, reserved 1048576K



     *
     * 换成 jdk1.7
     *
     * java version "1.7.0_71"
     Java(TM) SE Runtime Environment (build 1.7.0_71-b14)
     Java HotSpot(TM) 64-Bit Server VM (build 24.71-b01, mixed mode)

    直接永久区内存溢出了


     GC [PSYoungGen: 2642K->352K(76800K)] 2642K->352K(251392K), 0.0020870 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
     [Full GC [PSYoungGen: 352K->0K(76800K)] [ParOldGen: 0K->179K(120320K)] 352K->179K(197120K) [PSPermGen: 2044K->2044K(2048K)], 0.0079340 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
     [GC [PSYoungGen: 0K->0K(81920K)] 179K->179K(202240K), 0.0004130 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(81920K)] [ParOldGen: 179K->169K(232448K)] 179K->169K(314368K) [PSPermGen: 2044K->2044K(2048K)], 0.0041080 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC [PSYoungGen: 1628K->32K(100352K)] 1797K->201K(332800K), 0.0004620 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 32K->0K(100352K)] [ParOldGen: 169K->169K(360448K)] 201K->169K(460800K) [PSPermGen: 2047K->2047K(2048K)], 0.0045840 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC [PSYoungGen: 0K->0K(98304K)] 169K->169K(458752K), 0.0003960 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(98304K)] [ParOldGen: 169K->169K(559616K)] 169K->169K(657920K) [PSPermGen: 2047K->2047K(2048K)], 0.0059660 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC [PSYoungGen: 0K->0K(119296K)] 169K->169K(678912K), 0.0011180 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(119296K)] [ParOldGen: 169K->168K(760320K)] 169K->168K(879616K) [PSPermGen: 2047K->2047K(2048K)], 0.0079700 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
     [GC [PSYoungGen: 2170K->32K(119808K)] 2339K->200K(880128K), 0.0005540 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 32K->0K(119808K)] [ParOldGen: 168K->168K(1036800K)] 200K->168K(1156608K) [PSPermGen: 2047K->2047K(2048K)], 0.0099250 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
     [GC [PSYoungGen: 0K->0K(130048K)] 168K->168K(1166848K), 0.0004400 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(130048K)] [ParOldGen: 168K->168K(1323008K)] 168K->168K(1453056K) [PSPermGen: 2047K->2047K(2048K)], 0.0050650 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC [PSYoungGen: 0K->0K(132608K)] 168K->168K(1455616K), 0.0004680 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(132608K)] [ParOldGen: 168K->167K(1687040K)] 168K->167K(1819648K) [PSPermGen: 2047K->2047K(2048K)], 0.0053260 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC [PSYoungGen: 0K->0K(132608K)] 167K->167K(1819648K), 0.0004110 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(132608K)] [ParOldGen: 167K->167K(2074624K)] 167K->167K(2207232K) [PSPermGen: 2047K->2047K(2048K)], 0.0055880 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC [PSYoungGen: 0K->0K(139264K)] 167K->167K(2213888K), 0.0004610 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC [PSYoungGen: 0K->0K(139264K)] [ParOldGen: 167K->167K(2551296K)] 167K->167K(2690560K) [PSPermGen: 2047K->2047K(2048K)], 0.0097340 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     Error occurred during initialization of VM
     java.lang.OutOfMemoryError: PermGen space
     at sun.misc.Launcher.<init>(Launcher.java:71)
     at sun.misc.Launcher.<clinit>(Launcher.java:57)
     at java.lang.ClassLoader.initSystemClassLoader(ClassLoader.java:1489)
     at java.lang.ClassLoader.getSystemClassLoader(ClassLoader.java:1474)



     * @param args
     */

    public static void main(String[] args) {
        for(int i=0;i<100000;i++){
            System.out.println(i);
            CglibBean bean = new CglibBean("geym.jvm.ch3.perm.bean"+i,new HashMap());
        }
    }
}
