package com.example.leetcode.jianzhi;

import com.example.other.CASTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author:cafe3165
 * Date:2023-02-27
 */
public class T50 {
    public static void main(String[] args) {

        String s = "leetcode";
        char res = ' ';
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] chs = s.toCharArray();
        for(char c : chs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                continue;
            }
            res = entry.getKey();
        }
        System.out.println(res);


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1,2);

        PriorityQueue<CASTest> priorityQueue = new PriorityQueue<>((a, b) -> a.get() - b.get()
        );

        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1,1);

        ConcurrentHashMap<Integer, Integer> cmap = new ConcurrentHashMap<>();
        cmap.put(1,1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((i,j) -> i - j);


    }
}
