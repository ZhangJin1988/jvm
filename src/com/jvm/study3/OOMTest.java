package com.jvm.study3;

import java.util.Vector;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class OOMTest {

    /**
     * -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./a.dump

     * @param args
     */

    public static void main(String[] args) {
        Vector v=new Vector();
        for(int i=0;i<25;i++)
            v.add(new byte[1*1024*1024]);

    }
}
