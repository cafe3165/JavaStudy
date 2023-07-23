package com.example.other;

/**
 * Author:cafe3165
 * Date:2023-02-21
 */
public class DeadLockTest {

    public static final Object resource1 = new Object();

    public static final Object resource2 = new Object();


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("thread1 resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource2) {
                    System.out.println("thread1 resource2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("thread2 resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (resource1) {
                    System.out.println("thread2 resource2");
                }
            }
        });

        thread1.start();

        thread2.start();

    }
}
