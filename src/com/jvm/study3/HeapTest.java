package com.jvm.study3;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class HeapTest {


    /**
     *
     * @param args
     *
     * 1  -Xmx20m -Xms20m -Xmn1m  -XX:+PrintGCDetails

    有GC  大部分分配到老年代  可能因为初始的空间就不够
     输出

    [GC (Allocation Failure) [PSYoungGen: 512K->464K(1024K)] 512K->472K(19968K), 0.0025415 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 976K->416K(1024K)] 984K->432K(19968K), 0.0079507 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    Heap
    PSYoungGen      total 1024K, used 452K [0x00000007bfe80000, 0x00000007c0000000, 0x00000007c0000000)
    eden space 512K, 7% used [0x00000007bfe80000,0x00000007bfe89058,0x00000007bff00000)
    from space 512K, 81% used [0x00000007bff80000,0x00000007bffe8020,0x00000007c0000000)
    to   space 512K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007bff80000)
    ParOldGen       total 18944K, used 10256K [0x00000007bec00000, 0x00000007bfe80000, 0x00000007bfe80000)
    object space 18944K, 54% used [0x00000007bec00000,0x00000007bf6040a0,0x00000007bfe80000)
    Metaspace       used 2660K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 287K, capacity 386K, committed 512K, reserved 1048576K


     2 -Xmx20m -Xms20m -Xmn15m  -XX:+PrintGCDetails

    没有GC  全部分配到老年代
    输出
    PSYoungGen      total 13824K, used 12207K [0x00000007bf100000, 0x00000007c0000000, 0x00000007c0000000)
    eden space 12288K, 99% used [0x00000007bf100000,0x00000007bfcebf20,0x00000007bfd00000)
    from space 1536K, 0% used [0x00000007bfe80000,0x00000007bfe80000,0x00000007c0000000)
    to   space 1536K, 0% used [0x00000007bfd00000,0x00000007bfd00000,0x00000007bfe80000)
    ParOldGen       total 5120K, used 0K [0x00000007bec00000, 0x00000007bf100000, 0x00000007bf100000)
    object space 5120K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf100000)
    Metaspace       used 2659K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 287K, capacity 386K, committed 512K, reserved 1048576K


     3 -Xmx20m -Xms20m –Xmn7m  -XX:+PrintGCDetails

    两次GC 新生代太少 s0 s1 需要担保

    [GC (Allocation Failure) [PSYoungGen: 5405K->496K(6656K)] 5405K->1568K(19968K), 0.0012450 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 5734K->480K(6656K)] 6807K->2576K(19968K), 0.0009998 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
    Heap
    PSYoungGen      total 6656K, used 1565K [0x00000007bf900000, 0x00000007c0000000, 0x00000007c0000000)
    eden space 6144K, 17% used [0x00000007bf900000,0x00000007bfa0f748,0x00000007bff00000)
    from space 512K, 93% used [0x00000007bff80000,0x00000007bfff8000,0x00000007c0000000)
    to   space 512K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007bff80000)
    ParOldGen       total 13312K, used 2096K [0x00000007bec00000, 0x00000007bf900000, 0x00000007bf900000)
    object space 13312K, 15% used [0x00000007bec00000,0x00000007bee0c1c0,0x00000007bf900000)
    Metaspace       used 2660K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 287K, capacity 386K, committed 512K, reserved 1048576K

    Process finished with exit code 0


     3 -Xmx20m -Xms20m -Xmn7m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails

    进行了3次young GC  so s1变大

    [GC (Allocation Failure) [PSYoungGen: 3244K->1520K(5632K)] 3244K->1568K(18944K), 0.0013207 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 4670K->1520K(5632K)] 4719K->1568K(18944K), 0.0012390 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    [GC (Allocation Failure) [PSYoungGen: 4662K->1488K(5632K)] 4711K->1536K(18944K), 0.0007330 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    Heap
    PSYoungGen      total 5632K, used 3692K [0x00000007bf900000, 0x00000007c0000000, 0x00000007c0000000)
    eden space 4096K, 53% used [0x00000007bf900000,0x00000007bfb270d0,0x00000007bfd00000)
    from space 1536K, 96% used [0x00000007bfd00000,0x00000007bfe74020,0x00000007bfe80000)
    to   space 1536K, 0% used [0x00000007bfe80000,0x00000007bfe80000,0x00000007c0000000)
    ParOldGen       total 13312K, used 48K [0x00000007bec00000, 0x00000007bf900000, 0x00000007bf900000)
    object space 13312K, 0% used [0x00000007bec00000,0x00000007bec0c1a0,0x00000007bf900000)
    Metaspace       used 2660K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 287K, capacity 386K, committed 512K, reserved 1048576K

    Process finished w

     4 -Xmx20m -Xms20m -XX:NewRatio=1
    -XX:SurvivorRatio=2 -XX:+PrintGCDetails


    /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/bin/java -Xmx20m -Xms20m -XX:NewRatio=1 -XX:SurvivorRatio=2 -XX:+PrintGCDetails -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/tools.jar:/Users/zhangjin/myCode/learn/jvm/output com.jvm.study3.HeapTest
    [GC (Allocation Failure) [PSYoungGen: 4387K->1616K(7680K)] 4387K->1624K(17920K), 0.0014456 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    [GC (Allocation Failure) [PSYoungGen: 5810K->1552K(7680K)] 5818K->1568K(17920K), 0.0012279 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    Heap
    PSYoungGen      total 7680K, used 4817K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
    eden space 5120K, 63% used [0x00000007bf600000,0x00000007bf9305d8,0x00000007bfb00000)
    from space 2560K, 60% used [0x00000007bfd80000,0x00000007bff04020,0x00000007c0000000)
    to   space 2560K, 0% used [0x00000007bfb00000,0x00000007bfb00000,0x00000007bfd80000)
    ParOldGen       total 10240K, used 16K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
    object space 10240K, 0% used [0x00000007bec00000,0x00000007bec04000,0x00000007bf600000)
    Metaspace       used 2659K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 287K, capacity 386K, committed 512K, reserved 1048576K

    Process finished with exit code 0

     5 -Xmx20m -Xms20m -XX:NewRatio=1
    -XX:SurvivorRatio=3 -XX:+PrintGCDetails

    Heap
    PSYoungGen      total 8192K, used 2683K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
    eden space 6144K, 18% used [0x00000007bf600000,0x00000007bf71ed18,0x00000007bfc00000)
    from space 2048K, 75% used [0x00000007bfe00000,0x00000007bff80030,0x00000007c0000000)
    to   space 2048K, 0% used [0x00000007bfc00000,0x00000007bfc00000,0x00000007bfe00000)
    ParOldGen       total 10240K, used 8K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
    object space 10240K, 0% used [0x00000007bec00000,0x00000007bec02000,0x00000007bf600000)
    Metaspace       used 2657K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 287K, capacity 386K, committed 512K, reserved 1048576K



     */



    public static void main(String[] args) {
        byte[] b=null;
        for(int i=0;i<10;i++)
            b=new byte[1*1024*1024];
    }

}
