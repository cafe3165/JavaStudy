package GeekBang.Concurrent;

/**
 * Author:cafe3165
 * Date:2020-09-14
 */
public class Test1 {


    private static volatile long count = 0;

    private synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Test1 test = new Test1();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println( calc());
        SafeCalc s = new SafeCalc();

        Runnable target = () -> {
            for (int i = 0; i < 1000; i++) {
                SafeCalc.addOne();
            }
        };
        Thread th1 = new Thread(target);
        th1.start();
//        Thread th2 = new Thread(target);
//        th2.start();
        SafeCalc.addOne();
        System.out.println(s.get());
    }

    static class SafeCalc {
        static long value = 0L;

        synchronized long get() {
            return value;
        }

        synchronized static void addOne() {
            value += 1;
        }
    }

}
