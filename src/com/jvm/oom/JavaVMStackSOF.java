package com.jvm.oom;

/**
 * Created by zhangjin on 2017/11/8.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public  void stackLeak(){
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
     try {
         javaVMStackSOF.stackLeak();
     }catch (Throwable e){
         System.out.println("stack length : " + javaVMStackSOF.stackLength);
         throw e;
     }
    }
}
