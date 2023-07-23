package com.example.other;

import net.sf.json.util.JSONUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2023-03-04
 */
public class MemoryTest {
    public static void main(String[] args) {
//        byte[] b = new byte[10 * 1024 * 1024];
//        System.out.println("分配了10M空间给数组");
//        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");  //系统的最大空间
//        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");  //系统的空闲空间
//        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");  //当前可用的总空间


        List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 3));
        listA.add(4);

        List<Integer> listB  = new ArrayList<>(4);

//        Collections.copy(listB, listA);
//        for (Integer integer : listB) {
//            System.out.println(integer);
//        }

        int[] a = new int[]{1,2,3};
        int[] b = new int[3];

        System.arraycopy(a, 0, b, 0, a.length);
        int[] c = Arrays.copyOf(a, a.length);

        for (int i : b) {
            System.out.println(i);
        }

        for (int i : c) {
            System.out.println(i);
        }
    }
}
