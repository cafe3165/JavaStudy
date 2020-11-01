package Concurrency.ProCon;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class procontest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>(10);
    private Lock lock = new ReentrantLock();
    private Condition notF = lock.newCondition();
    private Condition notE = lock.newCondition();

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            notE.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i = queue.poll();
                    System.out.println("consume" + i + " " + queue.size());
                    notF.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 10) {
                        try {
                            notF.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    System.out.println("produce" + queue.size());
                    notE.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        procontest p = new procontest();
        p.new Producer().start();
        p.new Consumer().start();
    }
}
