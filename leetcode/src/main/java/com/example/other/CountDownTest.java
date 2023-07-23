package com.example.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Author:cafe3165
 * Date:2023-02-25
 */
public class CountDownTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> list = new ArrayList<>();

        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService es = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                list.add(Thread.currentThread().getName());
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String s : list) {
            System.out.println(s);
        }


        Future<Integer> result = es.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });

        System.out.println(result.get());

        ThreadLocal<Integer> local = new ThreadLocal<>();
        local.set(1);
        local.get();
        local.remove();

    }
}
