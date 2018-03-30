package com.jvm.study3;

import java.util.HashMap;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class PermTest {

    /**
     * 针对jdk1.8
     * -XX:MetaspaceSize=1m  -XX:MaxMetaspaceSize=2m  -XX:+PrintGCDetails
     * jdk1.8中 一直没有内存溢出
     *   1.8没有永久区的概率 多次执行后的GC日志 待分析
     *  几乎没有变化
     *
     *  jdk1.8的元数据区直接就在内存中 所以不存在 溢出 设置MaxPermSize不起作用
     *
     *  溢出了 1.7的设置参数 是不起作用的
     *
     *  java.lang.OutOfMemoryError: Metaspace
     *
     *
     * /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/bin/java -XX:MetaspaceSize=1m -XX:MaxMetaspaceSize=2m -XX:+PrintGCDetails -Dfile.encoding=UTF-8 -classpath /Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_73.jdk/Contents/Home/lib/tools.jar:/Users/zhangjin/myCode/learn/jvm/output:/Users/zhangjin/myCode/learn/jvm/lib/cglib-nodep-3.2.6.jar:/Users/zhangjin/myCode/learn/jvm/lib/asm-3.3.1.jar:/Users/zhangjin/myCode/learn/jvm/lib/cglib-2.2.2.jar com.jvm.study3.PermTest
     [GC (Metadata GC Threshold) [PSYoungGen: 2621K->336K(76288K)] 2621K->336K(251392K), 0.0010928 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 336K->0K(76288K)] [ParOldGen: 0K->207K(114176K)] 336K->207K(190464K), [Metaspace: 1801K->1801K(1056768K)], 0.0023315 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(113152K)] 207K->207K(227328K), 0.0005104 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(113152K)] [ParOldGen: 207K->203K(210432K)] 207K->203K(323584K), [Metaspace: 1801K->1801K(1056768K)], 0.0037142 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(131584K)] 203K->203K(342016K), 0.0004108 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(131584K)] [ParOldGen: 203K->203K(319488K)] 203K->203K(451072K), [Metaspace: 1801K->1801K(1056768K)], 0.0033972 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(141312K)] 203K->203K(460800K), 0.0005677 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(141312K)] [ParOldGen: 203K->203K(485376K)] 203K->203K(626688K), [Metaspace: 1801K->1801K(1056768K)], 0.0043266 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(141312K)] 203K->203K(626688K), 0.0003687 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(141312K)] [ParOldGen: 203K->203K(655360K)] 203K->203K(796672K), [Metaspace: 1801K->1801K(1056768K)], 0.0026075 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(147968K)] 203K->203K(803328K), 0.0003464 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(147968K)] [ParOldGen: 203K->203K(884736K)] 203K->203K(1032704K), [Metaspace: 1801K->1801K(1056768K)], 0.0026799 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(147968K)] 203K->203K(1032704K), 0.0008719 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(147968K)] [ParOldGen: 203K->202K(1109504K)] 203K->202K(1257472K), [Metaspace: 1801K->1801K(1056768K)], 0.0027584 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(169984K)] 202K->202K(1279488K), 0.0002862 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(169984K)] [ParOldGen: 202K->202K(1395712K)] 202K->202K(1565696K), [Metaspace: 1801K->1801K(1056768K)], 0.0026438 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(170496K)] 202K->202K(1566208K), 0.0003996 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(170496K)] [ParOldGen: 202K->202K(1695232K)] 202K->202K(1865728K), [Metaspace: 1801K->1801K(1056768K)], 0.0026174 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(184832K)] 202K->202K(1880064K), 0.0002975 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(184832K)] [ParOldGen: 202K->202K(2060800K)] 202K->202K(2245632K), [Metaspace: 1801K->1801K(1056768K)], 0.0028203 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(184832K)] 202K->202K(2245632K), 0.0003767 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(184832K)] [ParOldGen: 202K->202K(2452480K)] 202K->202K(2637312K), [Metaspace: 1801K->1801K(1056768K)], 0.0029920 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(200192K)] 202K->202K(2652672K), 0.0003323 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(200192K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(2996736K), [Metaspace: 1801K->1801K(1056768K)], 0.0028855 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(200192K)] 202K->202K(2996736K), 0.0003621 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(200192K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(2996736K), [Metaspace: 1801K->1801K(1056768K)], 0.0024193 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(216576K)] 202K->202K(3013120K), 0.0003810 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(216576K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3013120K), [Metaspace: 1801K->1801K(1056768K)], 0.0024209 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(216576K)] 202K->202K(3013120K), 0.0003579 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(216576K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3013120K), [Metaspace: 1801K->1801K(1056768K)], 0.0022184 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(233472K)] 202K->202K(3030016K), 0.0003029 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(233472K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3030016K), [Metaspace: 1801K->1801K(1056768K)], 0.0022681 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(233984K)] 202K->202K(3030528K), 0.0003556 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(233984K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3030528K), [Metaspace: 1801K->1801K(1056768K)], 0.0025269 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(245248K)] 202K->202K(3041792K), 0.0002908 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(245248K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3041792K), [Metaspace: 1801K->1801K(1056768K)], 0.0022120 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(245248K)] 202K->202K(3041792K), 0.0003432 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(245248K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3041792K), [Metaspace: 1801K->1801K(1056768K)], 0.0024124 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(257024K)] 202K->202K(3053568K), 0.0003826 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(257024K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3053568K), [Metaspace: 1801K->1801K(1056768K)], 0.0028548 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(257024K)] 202K->202K(3053568K), 0.0004989 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(257024K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3053568K), [Metaspace: 1801K->1801K(1056768K)], 0.0028055 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(269824K)] 202K->202K(3066368K), 0.0004006 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(269824K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3066368K), [Metaspace: 1801K->1801K(1056768K)], 0.0026147 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(269824K)] 202K->202K(3066368K), 0.0004647 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(269824K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3066368K), [Metaspace: 1801K->1801K(1056768K)], 0.0025636 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(283648K)] 202K->202K(3080192K), 0.0006156 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(283648K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3080192K), [Metaspace: 1801K->1801K(1056768K)], 0.0027917 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(283648K)] 202K->202K(3080192K), 0.0004877 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(283648K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3080192K), [Metaspace: 1801K->1801K(1056768K)], 0.0029230 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(294912K)] 202K->202K(3091456K), 0.0003723 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(294912K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3091456K), [Metaspace: 1801K->1801K(1056768K)], 0.0028008 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(295424K)] 202K->202K(3091968K), 0.0005829 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(295424K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3091968K), [Metaspace: 1801K->1801K(1056768K)], 0.0022632 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(307200K)] 202K->202K(3103744K), 0.0004433 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(307200K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3103744K), [Metaspace: 1801K->1801K(1056768K)], 0.0024489 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(307200K)] 202K->202K(3103744K), 0.0003674 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(307200K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3103744K), [Metaspace: 1801K->1801K(1056768K)], 0.0022450 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(320000K)] 202K->202K(3116544K), 0.0005145 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(320000K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3116544K), [Metaspace: 1801K->1801K(1056768K)], 0.0024536 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(320000K)] 202K->202K(3116544K), 0.0004960 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(320000K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3116544K), [Metaspace: 1801K->1801K(1056768K)], 0.0024190 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(334336K)] 202K->202K(3130880K), 0.0003752 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(334336K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3130880K), [Metaspace: 1801K->1801K(1056768K)], 0.0021355 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(334336K)] 202K->202K(3130880K), 0.0006069 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(334336K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3130880K), [Metaspace: 1801K->1801K(1056768K)], 0.0030018 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(347648K)] 202K->202K(3144192K), 0.0005509 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(347648K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3144192K), [Metaspace: 1801K->1801K(1056768K)], 0.0031789 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(347648K)] 202K->202K(3144192K), 0.0005485 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(347648K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3144192K), [Metaspace: 1801K->1801K(1056768K)], 0.0027502 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(360960K)] 202K->202K(3157504K), 0.0004723 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(360960K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3157504K), [Metaspace: 1801K->1801K(1056768K)], 0.0028389 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(360960K)] 202K->202K(3157504K), 0.0004592 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(360960K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3157504K), [Metaspace: 1801K->1801K(1056768K)], 0.0024615 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(373760K)] 202K->202K(3170304K), 0.0003763 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(373760K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3170304K), [Metaspace: 1801K->1801K(1056768K)], 0.0021487 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(373760K)] 202K->202K(3170304K), 0.0004097 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(373760K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3170304K), [Metaspace: 1801K->1801K(1056768K)], 0.0021792 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(387072K)] 202K->202K(3183616K), 0.0004164 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(387072K)] [ParOldGen: 202K->202K(2796544K)] 202K->202K(3183616K), [Metaspace: 1801K->1801K(1056768K)], 0.0022059 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(387072K)] 202K->202K(3183616K), 0.0004539 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(387072K)] [ParOldGen: 202K->177K(2796544K)] 202K->177K(3183616K), [Metaspace: 1801K->1801K(1056768K)], 0.0020592 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(399872K)] 177K->177K(3196416K), 0.0004626 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(399872K)] [ParOldGen: 177K->177K(2796544K)] 177K->177K(3196416K), [Metaspace: 1801K->1801K(1056768K)], 0.0022386 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(399872K)] 177K->177K(3196416K), 0.0003768 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(399872K)] [ParOldGen: 177K->176K(2796544K)] 177K->176K(3196416K), [Metaspace: 1801K->1801K(1056768K)], 0.0021559 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(412672K)] 176K->176K(3209216K), 0.0003293 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(412672K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3209216K), [Metaspace: 1801K->1801K(1056768K)], 0.0025485 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(413184K)] 176K->176K(3209728K), 0.0006047 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(413184K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3209728K), [Metaspace: 1801K->1801K(1056768K)], 0.0027402 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(426496K)] 176K->176K(3223040K), 0.0005376 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(426496K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3223040K), [Metaspace: 1801K->1801K(1056768K)], 0.0028444 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(426496K)] 176K->176K(3223040K), 0.0004672 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(426496K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3223040K), [Metaspace: 1801K->1801K(1056768K)], 0.0024620 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(440320K)] 176K->176K(3236864K), 0.0006156 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(440320K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3236864K), [Metaspace: 1801K->1801K(1056768K)], 0.0031019 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(440320K)] 176K->176K(3236864K), 0.0005506 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(440320K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3236864K), [Metaspace: 1801K->1801K(1056768K)], 0.0029462 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(454656K)] 176K->176K(3251200K), 0.0005244 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(454656K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3251200K), [Metaspace: 1801K->1801K(1056768K)], 0.0032919 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
     [GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(454656K)] 176K->176K(3251200K), 0.0005168 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [Full GC (Metadata GC Threshold) [PSYoungGen: 0K->0K(454656K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3251200K), [Metaspace: 1801K->1801K(1056768K)], 0.0026275 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     [GC (Last ditch collection) [PSYoungGen: 0K->0K(468480K)] 176K->176K(3265024K), 0.0003905 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     [Full GC (Last ditch collection) [PSYoungGen: 0K->0K(468480K)] [ParOldGen: 176K->176K(2796544K)] 176K->176K(3265024K), [Metaspace: 1801K->1801K(1056768K)], 0.0023212 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     Error occurred during initialization of VM
     java.lang.OutOfMemoryError: Metaspace
     <<no stack trace available>>

     [
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
