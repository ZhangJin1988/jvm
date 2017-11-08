package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjin on 2017/11/8.
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
