package Real;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:cafe3165
 * Date:2020-04-21
 */
public class ali {
    public static void concurrentPrint(int[] array, int k) throws InterruptedException {
        Thread[] ts = new Thread[k];
        for (int i = 0; i < k; i++) {
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                    }
                }
            });
        }

        for (int i = 0; i < k; i++) {
            ts[i].start();
            ts[i].join(i);
            System.out.println();

        }


    }

    public static volatile int[] a;
    private static AtomicInteger index = new AtomicInteger();
    private static CountDownLatch count;

    public static void concurrentPrint2(int[] array, int k) {
        a = array;
        count = new CountDownLatch(k);
        Thread[] ts = new Thread[a.length];

        ts[0] = new Thread(() -> {
            while (index.intValue() < a.length) {
                if (index.intValue() % k == 0 && index.intValue() < a.length) {
                    System.out.print("0"+a[index.intValue()] + " ");
                    index.incrementAndGet();

                }
//                count.countDown();
            }
        });
        ts[1] = new Thread(() -> {
            while (index.intValue() < a.length) {
                if (index.intValue() % k == 1 && index.intValue() < a.length) {
                    System.out.print("1"+a[index.intValue()] + " ");
                    index.incrementAndGet();

                }
//                count.countDown();
            }
        });
        ts[2] = new Thread(() -> {
            while (index.intValue() < a.length) {
                if (index.intValue() % k == 2 && index.intValue() < a.length) {
                    System.out.print("2"+a[index.intValue()] + " ");
                    index.incrementAndGet();

                }
//                count.countDown();
            }
        });

        for (int i = 0; i < k; i++) {
            ts[i].start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {2, 8, 11, 3, 6, 9};
        int k = 3;
//        concurrentPrint2(array, k);
        Semaphore semaphore = new Semaphore(10);
//        semaphore.
    }
}
