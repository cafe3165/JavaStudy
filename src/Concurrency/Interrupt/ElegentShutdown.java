package Concurrency.Interrupt;

public class ElegentShutdown extends Thread {
    private volatile boolean isShutdown = true;
    public void shutdown() {
        System.out.println("收到关闭通知");
//        isShutdown = false;
        interrupt();
    }
    @Override
    public void run() {
        while (this.isShutdown) {
            System.out.println("当前线程正在工作" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("打断正在工作的线程");
            }
        }
        System.out.println("销毁了");
    }
    public static void main(String[] args) {
        ElegentShutdown e0 = new ElegentShutdown();
        ElegentShutdown e1 = new ElegentShutdown();
        e0.start();
        e1.start();
//        e0.shutdown();
       // e2.shutdown();



    }
}
