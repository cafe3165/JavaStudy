package com.example.other;

import java.util.Objects;

/**
 * Author:cafe3165
 * Date:2023-02-13
 */
public class MultiThread {

    public static final Object lock = new Object();
    public static int a = 0;
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                while (a < 100) {
                    System.out.println(Thread.currentThread().getName() + " " + a);
                    a++;
                    lock.notify();
                    try {
                        if (a < 100) {
                            lock.wait();
                        }
                    } catch (Exception ignored) {

                    }
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                while (a < 100) {

                    System.out.println(Thread.currentThread().getName() + " " + a);
                    a++;
                    lock.notify();
                    try {
                        if (a < 100) {
                            lock.wait();
                        }
                    } catch (Exception ignored) {

                    }
                }
            }
        });
        thread2.start();

    }
}
