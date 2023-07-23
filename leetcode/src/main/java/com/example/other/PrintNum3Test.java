package com.example.other;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2023-06-11
 */
public class PrintNum3Test {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger i = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            while (i.get() < 10) {
                lock.lock();
                try {
                    if (i.get() % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i.get());
                        i.incrementAndGet();
                        condition.signal();
                    }
                    condition.await();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }, "thread-1");
        Thread thread2 = new Thread(() -> {
            while (i.get() < 10) {
                lock.lock();
                try {
                    if (i.get() % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i.get());
                        i.incrementAndGet();
                        condition.signal();
                    }
                    condition.await();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }, "thread-2");

        thread2.start();
        thread1.start();


    }
}
