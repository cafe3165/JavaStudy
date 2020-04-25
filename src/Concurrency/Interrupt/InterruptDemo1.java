package Concurrency.Interrupt;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class InterruptDemo1 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }

    public static void main(String[] args) {
        InterruptDemo1 thread = new InterruptDemo1();
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否已经停止 1？=" + Thread.interrupted());
            System.out.println("是否已经停止 2？=" + Thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }


}
