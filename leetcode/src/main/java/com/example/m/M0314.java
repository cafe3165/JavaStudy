package com.example.m;

/**
 * Author:cafe3165
 * Date:2023-03-14
 */
public class M0314 {

    public static Object lock = new Object();


    public static void main(String[] args) {
        char[] chs = new char[]{'a', 'b', 'c', 'd'};
        Thread numThread = new Thread(() -> {
            int num = 0;
           synchronized (lock) {
               while (num < 4) {
                   lock.notify();
                   System.out.println(Thread.currentThread().getName() + " " + num++);
                   try {
                       lock.wait();
                   } catch (Exception e) {

                   }
               }
               lock.notify();

           }
        }, "numThread");
        Thread charThread = new Thread(() -> {
            int num = 0;
            synchronized (lock) {
                while (num < chs.length) {
                    lock.notify();
                    System.out.println(Thread.currentThread().getName() + " " + chs[num++]);
                    try {
                        lock.wait();
                    } catch (Exception e) {
                    }
                    lock.notify();
                }

            }
        }, "charThread");
        numThread.start();
        charThread.start();



    }
}
