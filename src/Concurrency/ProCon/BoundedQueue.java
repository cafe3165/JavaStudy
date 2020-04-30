package Concurrency.ProCon;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class BoundedQueue {
    private LinkedList<Integer> buffer;    //生产者容器
    private int maxSize;           //容器最大值是多少
    private Lock lock;
    private Condition fullCondition;
    private Condition notFullCondition;

    BoundedQueue(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<Integer>();
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        notFullCondition = lock.newCondition();
    }

    /**
     * 生产者
     *
     * @param obj
     * @throws InterruptedException
     */
    public void put(Integer obj) throws InterruptedException {
        lock.lock();
        System.out.println("put获取锁" + Thread.currentThread().getName());//获取锁
        try {
            while (maxSize == buffer.size()) {
                notFullCondition.await();       //满了，添加的线程进入等待状态
            }
            buffer.add(obj);
            System.out.println("produce");
            fullCondition.signal(); //通知
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者
     *
     * @return
     * @throws InterruptedException
     */
    public Integer get() throws InterruptedException {
        Integer obj;
        lock.lock();
        System.out.println("get获取锁" + Thread.currentThread().getName());//获取锁

        try {
            while (buffer.size() == 0) { //队列中没有数据了 线程进入等待状态
                fullCondition.await();
            }
            obj = buffer.poll();
            System.out.println("consume" + obj);
            notFullCondition.signal(); //通知
        } finally {
            lock.unlock();
        }
        return obj;
    }

    public static void main(String[] args) {
        BoundedQueue b = new BoundedQueue(5);
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    b.put(i);
                }
            }
        });
        es.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    int i = b.get();
                }

            }
        });

        es.shutdown();

    }


}
