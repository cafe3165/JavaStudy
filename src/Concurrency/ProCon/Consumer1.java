package Concurrency.ProCon;

import java.util.concurrent.BlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class Consumer1 implements Runnable {
    private final BlockingQueue q;

    public Consumer1(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int i = (Integer) q.take();
                System.out.println("con" + i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
