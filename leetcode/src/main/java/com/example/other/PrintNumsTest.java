package com.example.other;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author:cafe3165
 * Date:2023-02-21
 */
public class PrintNumsTest {
    public static Integer num = 0;

    public static Object lock = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
           while(true) {
               if (num > 100) {
                   break;
               }
               synchronized (num) {
                   if (num % 2 == 0) {
                       System.out.println("thread1 " + num);
                       num++;
                   }
               }
           }
        });

        Thread thread2 = new Thread(() -> {
            while(true) {
                if (num > 100) {
                    break;
                }
                synchronized (num) {
                    if (num % 2 != 0) {
                        System.out.println("thread2 " + num);
                        num ++;
                    }
                }
            }
        });

//        thread1.start();
//        thread2.start();


        AtomicReference<Integer> m = new AtomicReference<>(0);
        Thread thread3 = new Thread(() -> {
            while(true) {
                if (m.get() > 100) {
                    break;
                }
                synchronized (lock) {
                    System.out.println("thread3 " + m.get());
                    m.getAndSet(m.get() + 1);

                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread4 = new Thread(() -> {
            while(true) {
                if (m.get() > 100) {
                    break;
                }
                synchronized (lock) {
                    System.out.println("thread4 " + m.get());
                    m.getAndSet(m.get() + 1);

                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });



        thread3.start();
        thread4.start();


    }


}
