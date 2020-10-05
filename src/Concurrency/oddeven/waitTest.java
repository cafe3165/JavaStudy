package Concurrency.oddeven;

/**
 * Author:cafe3165
 * Date:2020-09-24
 */
public class waitTest {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printOdd();
            }
        }, "thread-1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printEven();
            }
        }, "thread-2").start();
    }

}

class Print {

    private int flag = 1;//信号量。当值为1时打印数字，当值为2时打印字母
    private int count = 1;

    public synchronized void printOdd() {
        if (flag != 1) {
            //打印数字
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + count++);
        flag = 2;
        notify();
    }

    public synchronized void printEven() {
        if (flag != 2) {
            //打印字母
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + count++);
        flag = 1;
        notify();
    }
}
