package Concurrency;

/**
 * Author:cafe3165
 * Date:2020-03-16
 */
public class InterruptionInJava implements Runnable {

    private volatile static boolean on = false;
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(),"InterruptionInJava");
        //start thread
        testThread.start();
        Thread.sleep(2000);
        InterruptionInJava.on = true;
        testThread.interrupt();

        System.out.println("main end");

    }

    @Override
    public void run() {
        while(!on){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("caught exception: "+e);
            }
        }
    }
}
