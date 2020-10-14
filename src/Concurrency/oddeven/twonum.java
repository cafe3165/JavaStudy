package Concurrency.oddeven;

/**
 * Author:cafe3165
 * Date:2020-09-16
 */
public class twonum {
    private static Object lock = new Object();

    private static int i = 1;

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (i <= 10) {
                    synchronized (lock) {
                        if (i % 2 == 1) {
                            System.out.println("thread1  " + i++);
                        } else {
                            lock.notify();
                        }
                    }

                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (i <= 10) {
                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println("thread2  " + i++);
                        } else {
                            lock.notify();
                        }
                    }

                }
            }
        };
        thread1.start();
        thread2.start();
    }

}
