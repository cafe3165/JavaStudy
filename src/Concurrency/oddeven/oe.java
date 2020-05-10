package Concurrency.oddeven;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:cafe3165
 * Date:2020-05-05
 */
public class oe {
    public static final CyclicBarrier c = new CyclicBarrier(2);
    public static volatile int i = 0;

    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(2);

//        Runnable target;
        Thread thread1 = new Thread(() -> {
            while (i < 100) {
                System.out.println(i+Thread.currentThread().getName());
                i++;
                try {
                    c.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            while (i < 100) {
                System.out.println(i+Thread.currentThread().getName());
                i++;
                try {
                    c.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}
