package Concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-03-13
 */
public class Producer implements Runnable {
    private final BlockingQueue sharequeue;

    public Producer(BlockingQueue q) {
        this.sharequeue = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("producer" + i);
                sharequeue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
