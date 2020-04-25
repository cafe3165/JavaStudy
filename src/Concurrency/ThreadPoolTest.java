package Concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(3, 5, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10), new ThreadFactoryBuilder().setNameFormat("thread-pool%d").build(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 7; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"666");
//                    return

                }
            });
        }
        System.out.println("main");
       List<Runnable> l= es.shutdownNow();
        System.out.println(l.size());
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i)+"9999");
        }


    }


}

