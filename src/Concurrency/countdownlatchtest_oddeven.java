package Concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:cafe3165
 * Date:2020-03-17
 */
public class countdownlatchtest_oddeven {
    private static AtomicInteger num = new AtomicInteger();
    private static CountDownLatch count = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService es = new ThreadPoolExecutor(1, 2, 300, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), tf, new ThreadPoolExecutor.AbortPolicy());


        es.execute(() -> {
            while (num.intValue() < 10) {
                if (num.intValue() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "偶数线程"+num.intValue());
                    num.incrementAndGet();
                }
                count.countDown();
            }
        });

        es.execute(() -> {
            while (num.intValue() < 10) {
                if (num.intValue() % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "奇数线程"+num.intValue());
                    num.incrementAndGet();
                }
                count.countDown();
            }
        });

        count.await();
        es.shutdown();


    }


}
