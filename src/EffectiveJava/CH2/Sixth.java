package EffectiveJava.CH2;

import java.util.regex.Pattern;

/**
 * Author:cafe3165
 * Date:2020-06-07
 */
public class Sixth {
    public static boolean isRomaNum(String num) {
        return num.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomaNum2(String num) {
        return ROMAN.matcher(num).matches();
    }

    public static long sum1() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sum2() {
        long sum = 0;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
//        int n = 10000;
//        long startTime = System.currentTimeMillis();    //获取开始时间
//        for (int i = 0; i < n; i++) {
//            isRomaNum("XXXI");    //测试的代码段
//        }
//        long endTime = System.currentTimeMillis();    //获取结束时间
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
//
//        long startTime2 = System.currentTimeMillis();    //获取开始时间
//        for (int i = 0; i < n; i++) {
//            isRomaNum2("XXXI");    //测试的代码段
//        }
//        long endTime2 = System.currentTimeMillis();    //获取结束时间
//        System.out.println("程序运行时间：" + (endTime2 - startTime2) + "ms");

        long startTime3 = System.currentTimeMillis();    //获取开始时间
        System.out.println(sum1());
        long endTime3 = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime3 - startTime3) + "ms");

        long startTime4 = System.currentTimeMillis();    //获取开始时间
        System.out.println(sum2());
        long endTime4 = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime4 - startTime4) + "ms");


    }
}
