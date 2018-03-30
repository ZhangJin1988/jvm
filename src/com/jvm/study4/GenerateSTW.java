package com.jvm.study4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjin on 2018/3/30.
 */

public class GenerateSTW {
    /**
     *
     * 垃圾回收参数 -Xms512m -Xmx512m -Xmn4m -XX:+PrintGCDetails -XX:+UseSerialGC
     * 通过集合引用对象，保证对象不被gc回收
     *
     * 不停的触发 full GC
     *
     * Full GC[Tenured: 520191K->520191K(520192K), 0.1063670 secs] 523902K->523902K(523904K), [Perm : 2628K->2628K(21248K)], 0.1063930 secs] [Times: user=0.10 sys=0.00, real=0.10 secs]
     [Full GC[Tenured: 520191K->520191K(520192K), 0.0995740 secs] 523902K->523902K(523904K), [Perm : 2628K->2628K(21248K)], 0.0995970 secs] [Times: user=0.10 sys=0.00, real=0.10 secs]
     [Full GC[Tenured: 520191K->520191K(520192K), 0.2579160 secs] 523903K->523901K(523904K), [Perm : 2636K->2636K(21248K)], 0.2579440 secs] [Times: user=0.26 sys=0.01, real=0.26 secs]
     Heap
     def new generation   total 3712K, used 3709K [0x00000007dae00000, 0x00000007db200000, 0x00000007db200000)
     eden space 3328K, 100% used [0x00000007dae00000, 0x00000007db140000, 0x00000007db140000)
     from space 384K,  99% used [0x00000007db140000, 0x00000007db19f7b8, 0x00000007db1a0000)
     to   space 384K,   0% used [0x00000007db1a0000, 0x00000007db1a0000, 0x00000007db200000)
     tenured generation   total 520192K, used 520191K [0x00000007db200000, 0x00000007fae00000, 0x00000007fae00000)
     the space 520192K,  99% used [0x00000007db200000, 0x00000007fadffff0, 0x00000007fae00000, 0x00000007fae00000)
     compacting perm gen  total 21248K, used 2637K [0x00000007fae00000, 0x00000007fc2c0000, 0x0000000800000000)
     the space 21248K,  12% used [0x00000007fae00000, 0x00000007fb093410, 0x00000007fb093600, 0x00000007fc2c0000)
     No shared spaces configured.

     */
    private List<byte[]> content=new ArrayList<byte[]>();
    public static void main(String[] args) {
        GenerateSTW stw=new GenerateSTW();
        stw.start();
    }

    private void start() {
        while(true){
            try {
                content.add(new byte[1024]);
            } catch (OutOfMemoryError e) {
                //在不可以分配的时候，进行清理部分空间,继续运行，这样会很快产生下一次垃圾回收
                for(int i=0;i<1024;i++){
                    content.remove(i);
                }

            }

        }
    }

}
