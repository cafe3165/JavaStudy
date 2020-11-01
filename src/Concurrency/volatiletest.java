package Concurrency;

import java.util.TreeMap;
import java.util.concurrent.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Author:cafe3165
 * Date:2020-03-28
 */
public class volatiletest implements Runnable {
    volatile static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        volatiletest demo1 = new volatiletest();
        volatiletest demo2 = new volatiletest();
        volatiletest demo3 = new volatiletest();
//        ExecutorService es=new ThreadPoolExecutor(3,6,300, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(4),new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build(),new ThreadPoolExecutor.AbortPolicy());
        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);
        Thread t3 = new Thread(demo3);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(3000);

        System.out.println(volatiletest.count);
    }
}
