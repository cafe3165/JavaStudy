package Concurrency.ProCon;

import lombok.SneakyThrows;

import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class Producer2 extends Thread {
    private final PriorityQueue<Integer> queue;

    public Producer2(PriorityQueue<Integer> queue) {
        this.queue = queue;
    }

    @SneakyThrows
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 3) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        queue.notify();
                    }
                }
                System.out.println("produce");
                queue.offer(1);
                queue.notify();
            }
        }
    }
}
