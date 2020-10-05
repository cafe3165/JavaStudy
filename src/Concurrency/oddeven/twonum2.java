package Concurrency.oddeven;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2020-09-16
 */
public class twonum2 implements Runnable {
    private static ReentrantLock fairLock = new ReentrantLock(true);
    private static int i = 1;

    @Override
    public void run() {
        while (i < 100) {
            fairLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " " + i++);
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        twonum2 r1 = new twonum2();
        Thread t1 = new Thread(r1, "Thread_t1");

        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();

        t2.start();
    }
}
