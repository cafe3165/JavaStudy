package com.example.other;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2023-03-04
 */
public class PrintNum2Test {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        char[] chs = new char[]{'a', 'b', 'c'};
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (i < 10) {
                synchronized (lock) {
//                    lock.notify();
                    System.out.println(Thread.currentThread().getName() + " " + nums[i % nums.length]);
                    i++;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
//                    lock.notify();
                }


            }
        }, "thread1-num");

        Thread thread2 = new Thread(() -> {
            int i = 0;
            while (i < 10) {
                synchronized (lock) {
//                    lock.notify();

                    System.out.println(Thread.currentThread().getName() + " " + chs[i % chs.length]);
                    i++;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        }, "thread2-char");
//        thread2.start();
//        thread1.start();

        Lock rl = new ReentrantLock();
        Condition numCon = rl.newCondition();
        Condition charCon = rl.newCondition();


        Thread thread3 = new Thread(() -> {
            rl.lock();
            int i = 0;
            try {
                while (i < 10) {
                    System.out.println(Thread.currentThread().getName() + " " + nums[i % nums.length]);
                    i++;
                    charCon.signal();
                    numCon.await();
                }
                charCon.signal();
            } catch (Exception e) {

            } finally {
                rl.unlock();
            }
        }, "thread3-num");

        Thread thread4 = new Thread(() -> {
            rl.lock();
            int i = 0;
            try {
                while (i < 10) {
                    System.out.println(Thread.currentThread().getName() + " " + chs[i % chs.length]);
                    i++;
                    numCon.signal();
                    charCon.await();
                }
                numCon.signal();
            } catch (Exception e) {

            } finally {
                rl.unlock();
            }
        }, "thread4-char");
        thread4.start();
        thread3.start();


    }
}
