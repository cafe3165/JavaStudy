package com.example.m;

import java.lang.ref.Reference;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2023-03-27
 */
public class AliFeiZhu_1 {
    public static ReentrantLock lock = new ReentrantLock();

    public static Condition ca = lock.newCondition();
    public static Condition cb = lock.newCondition();
    public static Condition cc = lock.newCondition();
    public static Condition cd = lock.newCondition();

    public static volatile AtomicInteger num = new AtomicInteger(1);


    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            while (num.get() <= 100) {
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (Exception e) {
                }
                lock.lock();
                try {
                    cb.signal();
                    ca.await();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                num.incrementAndGet();
                System.out.println("A : " + num.get());
            }
            lock.lock();
            try {
                cb.signal();
                cc.signal();
                cd.signal();
            } finally {
                lock.unlock();
            }

        });

        Thread threadB = new Thread(() -> {

            while (num.get() < 100) {
                lock.lock();
                try {
                    System.out.println("B await");
                    cb.await();
                    if (num.get() % 2 == 0) {
                        System.out.println(num + "B");
                        ca.signal();

                    } else {
                        cc.signal();
                    }

                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }


            }
        });

        Thread threadC = new Thread(() -> {

            while (num.get() < 100) {
                lock.lock();
                try {
                    System.out.println("C await");

                    cc.await();
                    if (num.get() % 3 == 0) {
                        System.out.println(num + "C");
                        ca.signal();
                    } else {
                        cd.signal();
                    }

                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        });

        Thread threadD = new Thread(() -> {

            while (num.get() < 100) {
                lock.lock();
                try {
                    System.out.println("D await");
                    cd.await();
                    if (num.get() % 3 != 0 && num.get() % 2 != 0) {
                        System.out.println(num + "D");
                    }
                    ca.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }
}
