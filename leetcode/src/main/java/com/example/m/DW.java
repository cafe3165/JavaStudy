package com.example.m;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author:cafe3165
 * Date:2023-06-03
 */
public class DW {

    public static List<Integer> devide(Integer n, int x) {
        if (x <= 0) {
            return new ArrayList<>();
        }
        if (n < 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < x - 1; i++) {
            int bound = n - count - i;
            int r = new Random(System.currentTimeMillis()).nextInt(bound);
            count += r;
            System.out.println(r);
            res.add(r);
        }
        System.out.println( n - count);
        res.add(n - count);

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = devide(100,5);
//        for (Integer re : res) {
//            System.out.println(re);
//        }
    }
}
