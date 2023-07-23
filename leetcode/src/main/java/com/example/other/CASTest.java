package com.example.other;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Author:cafe3165
 * Date:2023-02-25
 */
public class CASTest {

    private int a = 0;

    private synchronized void increase() {
        a++;
    }

    public int get() {
        return a;
    }


    public static void main(String[] args) {

//        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,0);
//
//        atomicStampedReference.compareAndSet(atomicStampedReference.getReference(),99,
//                atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
//
//        System.out.println(atomicStampedReference.getReference());


        CASTest casTest = new CASTest();

        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (casTest) {
                    System.out.println(Thread.currentThread().getName() + "get lock " + casTest.get());
                    if (casTest.get() >= 100) {
                        break;
                    }
                    casTest.increase();
                }
            }
        }, "Thread-1");
        thread1.start();
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (casTest) {
                    System.out.println(Thread.currentThread().getName() + "get lock " + casTest.get());
                    if (casTest.get() >= 100) {
                        break;
                    }
                    casTest.increase();
                }
            }
        }, "Thread-2");
        thread2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(casTest.get());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {

            Integer res = 0;
            try {
                Thread.sleep(1000);
                res = 1;
            } catch (InterruptedException e) {
                res = -1;
            }
            return res;

        }, Executors.newSingleThreadExecutor());

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

//        CompletableFuture.allOf()
    }
}
