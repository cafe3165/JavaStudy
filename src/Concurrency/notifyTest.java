package Concurrency;

public class notifyTest {
    public static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA Lock");
                    try {
                        System.out.println("ta begin wait");
                        resourceA.wait();
                        System.out.println("ta end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA Lock");
                    try {
                        System.out.println("tb begin wait");
                        resourceA.wait();
                        System.out.println("tb end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("tc beagin notify");
//                    resourceA.notify();
                    resourceA.notifyAll();
                }
            }
        });
        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
