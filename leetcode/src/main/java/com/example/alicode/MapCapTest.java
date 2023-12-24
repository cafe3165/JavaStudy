package com.example.alicode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2023-07-23
 */
public class MapCapTest {

    public static void main(String[] args) {
        int n = 10240;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>(n * n);
        Long t1 = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                map1.put(i, i);
            }
        }

        Long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        t1 = System.currentTimeMillis();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                map2.put(i, i);
            }
        }

        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

    }
}
