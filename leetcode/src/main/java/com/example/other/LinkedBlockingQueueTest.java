package com.example.other;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2023-04-17
 */
public class LinkedBlockingQueueTest {

    static class MyLinkedBlockingQueue<T> {
        public LinkedList<T> queue;
        public AtomicInteger count = new AtomicInteger(0);
        private final Lock putLock = new ReentrantLock();
        private Condition notFull = putLock.newCondition();
        private final Lock getLock = new ReentrantLock();
        private Condition notEmpty = getLock.newCondition();

        public MyLinkedBlockingQueue(){
            queue = new LinkedList<>();
        }

        public T get(){
            T res = null;
            try {
                getLock.lockInterruptibly();
                while (count.get() == 0) {
                    notEmpty.await();
                }
                res = queue.pollFirst();
                count.getAndDecrement();
                if (count.get() > 0) {
                    notEmpty.signalAll();
                }
                signalNotFull();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                getLock.unlock();
            }

            return res;
        }

        private void signalNotFull() {
            putLock.lock();
            try {
                notFull.signal();
            } finally {
                putLock.unlock();
            }
        }

    }


    public static void main(String[] args) {




    }
}
