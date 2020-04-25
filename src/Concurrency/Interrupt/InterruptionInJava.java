package Concurrency.Interrupt;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class InterruptionInJava implements Runnable {
    private volatile static boolean on = false;

    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(), "InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(1000);
        //interrupt thread

        InterruptionInJava.on = true;
        testThread.interrupt();
        System.out.println("main end");

    }

    @Override
    public void run() {
        while (!on) {
//            if(Thread.currentThread().isInterrupted()){
//                System.out.println("Yes,I am interruted,but I am still running");
////                return;
//            }else{
//                System.out.println("not yet interrupted");
//            }
            try {
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
