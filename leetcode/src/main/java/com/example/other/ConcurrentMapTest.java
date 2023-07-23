package com.example.other;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:cafe3165
 * Date:2023-03-04
 */
public class ConcurrentMapTest {


    public static ConcurrentHashMap<String, Integer> cMap = new ConcurrentHashMap<>();


    private void increase(String url){

        while(true) {
            if (cMap.get(url) == null) {
                Integer val = cMap.putIfAbsent(url, 0);
                if (val == null) {
                    break;
                }
            }

           boolean res = cMap.replace(url, cMap.getOrDefault(url, 0), cMap.getOrDefault(url, 0) + 1);
           if (res) {
               break;
           }
        }
    }


    private Integer getCount(String url) {
        return cMap.get(url);
    }


    public static void main(String[] args) {

        String url = "www.baidu.com";
        ConcurrentMapTest concurrentMapTest = new ConcurrentMapTest();
        ExecutorService es = Executors.newFixedThreadPool(50);
        int times = 100000;
        CountDownLatch cdl = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            es.execute(() -> {
                concurrentMapTest.increase(url);
                cdl.countDown();
            });
        }

        try {
            cdl.await();
        } catch (Exception e) {

        }
        es.shutdown();
        System.out.println(concurrentMapTest.getCount(url));

    }
}
