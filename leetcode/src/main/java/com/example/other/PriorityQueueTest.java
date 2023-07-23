package com.example.other;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2023-03-04
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);

        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);

//        System.out.println(pq.peek());
//        System.out.println(pq.size());

        HashMap<String, String> map = new HashMap<>(1);
        map.put("1","1");
        System.out.println(tableSizeFor(6));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

}
