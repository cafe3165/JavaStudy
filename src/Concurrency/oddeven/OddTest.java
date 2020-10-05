package Concurrency.oddeven;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Author:cafe3165
 * Date:2020-09-24
 */
public class OddTest {
    static int count = 0;
    private static Object lock = new Object();

    static class Task1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count < 20) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " " + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (count < 20) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task1(), "thrad-1");
        Thread thread2 = new Thread(new Task2(), "thrad-2");
        thread1.start();
        thread2.start();
    }
}


