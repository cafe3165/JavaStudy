package Concurrency;

/**
 * Author:cafe3165
 * Date:2020-03-08
 */
public class NoteInterrupt3 {
    static class Example3 extends Thread {
        volatile boolean stop = false;

        public static void main(String args[]) throws Exception {
            Example3 thread = new Example3();
            System.out.println("Starting thread...");
            thread.start();
            Thread.sleep(3000);
            System.out.println("Asking thread to stop...");
            thread.stop = true;
            //如果线程阻塞，将不会检查此变量
            thread.interrupt();
            Thread.sleep(3000);
            System.out.println("Stopping application...");
            System.exit(0);
        }

        @Override
        public void run() {
            while (!stop) {
                System.out.println("Thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted...");
                }
            }
            System.out.println("Thread exiting under request...");
        }
    }


}
