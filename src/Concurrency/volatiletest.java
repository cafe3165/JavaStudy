package Concurrency;

import java.util.concurrent.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Author:cafe3165
 * Date:2020-03-28
 */
public class volatiletest implements Runnable{
    volatile private int count = 0;

    private void add(){
        for (int i = 0; i < 20; i++) {
            count++;
            System.out.println(Thread.currentThread().getName()+"count = " + count);

//            try {
//                Thread.sleep(5L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void run() {
        add();

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        volatiletest demo = new volatiletest();
        ExecutorService es=new ThreadPoolExecutor(3,6,300, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(4),new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build(),new ThreadPoolExecutor.AbortPolicy());
//        Thread t1 = new Thread(demo);
//        Thread t2 = new Thread(demo);
//        Thread t3 = new Thread(demo);
//        es.execute(t1);
//        es.execute(t2);
        for (int i = 0; i < 10; i++) {
            es.submit(demo);
//            f.get();
//            System.out.println(f.get());
        }
//        t1.start();
//        t2.start();
//        t3.start();

    }
}
