package com.example.other;

import net.sf.json.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author:cafe3165
 * Date:2023-02-14
 */
public class QueueTest {


    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();

//        linkedList.addFirst();
//        Queue<Integer> q = new LinkedList<>();
//        q.offer();
        int[] dp = new int[10];
//        Arrays.fill(dp , 1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        Integer[] dpArray = Arrays.stream(dp).boxed().toArray(Integer[]::new);
        Arrays.sort(dpArray, (i, j) -> 1);
        System.out.println(JSONArray.fromObject(dpArray).toString());
        List<Integer> list = new ArrayList<>();
        dpArray = list.toArray(new Integer[0]);

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.addFirst();
//        linkedList.addLast();
//        Integer n =  linkedList.removeFirst();
//        linkedList.size()

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        threadLocal.set(2);
        System.out.println(threadLocal.get());
    }

}
