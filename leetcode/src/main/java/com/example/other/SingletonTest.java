package com.example.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:cafe3165
 * Date:2023-02-25
 */
public class SingletonTest {

    private static volatile SingletonTest instance;

    private SingletonTest(){

    }

    public static SingletonTest getInstance(){
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        final Integer m = 0;
        ExecutorService es = Executors.newFixedThreadPool(10);

        es.submit(()->{
            for (int i = 0; i < 100; i++) {
                integer.incrementAndGet();

            }
        });

        es.submit(()->{
            for (int i = 0; i < 100; i++) {
                integer.incrementAndGet();

            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(integer.get());
        System.out.println(m);


    }

}
