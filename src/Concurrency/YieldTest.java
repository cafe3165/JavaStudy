package Concurrency;

public class YieldTest implements Runnable {
    YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + "yield cpu");
                Thread.yield();
            }

        }
        System.out.println(Thread.currentThread() + " is over");
    }


    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();

    }

}
