package Concurrency;

public class InterruptTest2 {
    public static void main(String[] args) throws InterruptedException{
        Thread threadone = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("thread begin for 2000");
                    Thread.sleep(2000);
                    System.out.println("thread awaking");
                }catch (InterruptedException e) {
                    System.out.println("threadone is interrupted while sleeping");
                    System.out.println(e.getMessage());
                    return;
                }
            }
        });
        threadone.start();
        Thread.sleep(1000);
//        直接打断子进程的休眠
        threadone.interrupt();
        threadone.join();
        System.out.println("main is over");
    }
}
