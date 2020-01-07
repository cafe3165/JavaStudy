package Concurrency;

public class Diff2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()){

                }
//                interrupted函数会清除中断标志
                System.out.println("threadone isinter.."+Thread.currentThread().isInterrupted());
            }
        });
        threadOne.start();
        threadOne.interrupt();
        threadOne.join();
        System.out.println("main is over");
    }
}
