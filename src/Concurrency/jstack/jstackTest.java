package Concurrency.jstack;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;

/**
 * Author:cafe3165
 * Date:2020-09-19
 */
public class jstackTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Object lock = new Object();
        es.submit(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    int i = 0;
                    while (true) {
                        i++;
                    }
                }
            }
        });
        es.submit(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    int i = 0;
                    while (i<10) {
                        i++;
                    }
                }
            }
        });
    }
}
