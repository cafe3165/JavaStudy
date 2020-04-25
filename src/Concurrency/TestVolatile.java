package Concurrency;


/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class TestVolatile {
    public volatile int inc = 0;

    public  void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final TestVolatile test = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }

//        while (Thread.activeCount() > 1) {
//            Thread.yield();

//        }
        Thread.sleep(5000);
        System.out.println(Thread.activeCount());
        System.out.println(test.inc);
    }


}
