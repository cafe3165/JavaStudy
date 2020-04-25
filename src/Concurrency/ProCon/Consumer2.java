package Concurrency.ProCon;

import lombok.SneakyThrows;

import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class Consumer2 extends Thread {
    private final PriorityQueue<Integer> queue;

    public Consumer2(PriorityQueue<Integer> queue) {
        this.queue = queue;
    }


    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        queue.notify();
                    }
                }
                int i = queue.poll();
                System.out.println("consume" + i);
                queue.notify();
            }
        }
    }
}
