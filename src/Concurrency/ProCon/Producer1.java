package Concurrency.ProCon;

import java.util.concurrent.BlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class Producer1 implements Runnable {
    private final BlockingQueue q;

    public Producer1(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("pro" + i);
                q.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
