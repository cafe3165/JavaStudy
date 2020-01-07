package Concurrency;

public class Diff {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
        threadOne.start();
        threadOne.interrupt();
        System.out.println(threadOne.isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(threadOne.isInterrupted());
        threadOne.join();
        System.out.println("main is over");
    }
}
