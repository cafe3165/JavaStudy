package Concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:cafe3165
 * Date:2020-03-14
 */
public class ReadWriteLockTest {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock ();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("Thread real execute");
                lock.writeLock().unlock();
            }
        });

        lock.writeLock().lock();
        lock.writeLock().lock();
        t.start();
        Thread.sleep(200);

        System.out.println("realse one once");
        lock.writeLock().unlock();
    }
}
