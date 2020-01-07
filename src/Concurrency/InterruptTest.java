package Concurrency;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread()+"hello");
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("begin");
        thread.interrupt();
        thread.join();
        System.out.println("main is over");
    }
}
