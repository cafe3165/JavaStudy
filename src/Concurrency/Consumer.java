package Concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-03-13
 */
public class Consumer implements Runnable {
    private final BlockingQueue sharequeue;

    public Consumer(BlockingQueue q) {
        this.sharequeue = q;
    }

    @Override
    public void run() {
        try {
            int i = (Integer) sharequeue.take();
            System.out.println("consumer" + i);

        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }

    }
}
