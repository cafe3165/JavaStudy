package Concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:cafe3165
 * Date:2020-03-28
 */
class AtomicIntegerTest implements Runnable {
    private AtomicInteger count = new AtomicInteger();

    //使用AtomicInteger之后，不需要对该方法加锁，也可以实现线程安全。
    public void increment() {
        count.incrementAndGet();
        System.out.println(Thread.currentThread().getName()+" "+count.get());
    }

    public int getCount() {
        return count.get();
    }

    public static void main(String[] args) {
        AtomicIntegerTest at = new AtomicIntegerTest();
        ExecutorService es = new ThreadPoolExecutor(2, 3, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1), new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 2; i++) {
            es.execute(at);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            increment();
        }
    }
}