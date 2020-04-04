package Concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Author:cafe3165
 * Date:2020-03-17
 *
 * @blame Android Team
 */
public class ThreadLocalTest {
    static ThreadLocal<String> localVar = new ThreadLocal<>();
    public static void print(String threadname){
        System.out.println(threadname+localVar.get());
        localVar.remove();
    }

    public static void main(String[] args) {
        ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ExecutorService es = new ThreadPoolExecutor(1, 10, 300, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), tf, new ThreadPoolExecutor.AbortPolicy());
        es.execute(() -> {
            localVar.set("11");
            print(Thread.currentThread().getName());
            System.out.println(localVar.get());
//            print(Thread);
        });
        es.execute(() -> {
            localVar.set("222");
            print(Thread.currentThread().getName());
            System.out.println(localVar.get());

        });




    }


}
