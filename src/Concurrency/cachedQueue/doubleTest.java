package Concurrency.cachedQueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class doubleTest {

    public static void main(String[] args) throws InterruptedException {
        final int count = 10000 * 1000;
        test1(count);// 975
        test2(count);//1756
    }

    public static void test1(int count) throws InterruptedException {
        DoubleBlockingQueue<Integer> queue1 = new DoubleBlockingQueue<>();
        long l = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < count) {
                queue1.add(i++);
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            while (true) {
                Integer poll = queue1.poll();
                if (poll != null && poll == count - 1)
                    return;
            }
        });
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(System.currentTimeMillis() - l);
    }

    public static void test2(int count) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue1 = new LinkedBlockingQueue();
        long l = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int i = 0;
            while (i < count) {
                queue1.add(i++);
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            while (true) {
                Integer poll = queue1.poll();
                if (poll != null && poll == count - 1)
                    return;
            }
        });
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println(System.currentTimeMillis() - l);

    }
}
