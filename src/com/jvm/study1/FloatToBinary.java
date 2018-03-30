package com.jvm.study1;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class FloatToBinary {


    public static void main(String[] args) {
        String value=convert(100.2f);
        System.out.println(value);
    }

    public static String convert(float num) {
        int intVal = Float.floatToIntBits(num);
        return intVal > 0 ? "0" + Integer.toBinaryString(intVal) : Integer
                .toBinaryString(intVal);
    }
}
