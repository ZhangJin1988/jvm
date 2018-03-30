package com.jvm.study1;

/**
 * Created by zhangjin on 2018/3/30.
 */
public class IntegerToBinary {


    public static String convert(Integer num) {

        StringBuffer sb = new StringBuffer();
        if (num == null) {
            return sb.toString();
        }
        for (int i = 0; i < 32; i++) {
            int t = (num & 0x80000000 >>> i) >>> (31 - i);
            sb.append(t);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int a = -6;
        int b = 6;
        String convert = convert(a);
        String convert2 = convert(b);
        System.out.println("------------");
        System.out.println(convert);
        System.out.println(convert2);

    }
}
