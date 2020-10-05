package Concurrency.oddeven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2020-09-16
 */
public class OddEvenPrinterEx implements Runnable{
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private final int limit;
    private  int count;

    public OddEvenPrinterEx(int limit, int initCount) {
        this.limit = limit;
        this.count = initCount;
    }
    @Override
    public void run() {
        lock.lock();
        try {
            while (count < limit){
                System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                condition.signal();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        OddEvenPrinterEx printer = new OddEvenPrinterEx(10, 0);
        Thread thread1 = new Thread(printer, "thread-1");
        Thread thread2 = new Thread(printer, "thread-2");
        thread1.start();
        thread2.start();
//        Thread.sleep(Integer.MAX_VALUE);
    }

}
