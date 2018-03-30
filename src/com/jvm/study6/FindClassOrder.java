package com.jvm.study6;

/**
 * Created by zhangjin on 2018/3/30.
 */


public class FindClassOrder {
//    public static void main(String args[]) {
//        HelloLoader loader = new HelloLoader();
//        loader.print();
//    }

    public static void main(String args[]) throws Exception {
        ClassLoader cl=FindClassOrder.class.getClassLoader();
//        byte[] bHelloLoader= LoadClass("com.jvm.study6.HelloLoader");
//        Method md_defineClass=ClassLoader.class.getDeclaredMethod("defineClass", byte[].class,int.class,int.class);
//        md_defineClass.setAccessible(true);
//        md_defineClass.invoke(cl, bHelloLoader,0,bHelloLoader.length);
//        md_defineClass.setAccessible(false);
//
//        HelloLoader loader = new HelloLoader();
//        System.out.println(loader.getClass().getClassLoader());
//        loader.print();
    }

}
