package Concurrency;

public class DaemonThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override

            public void run() {
                for(;;){

                }
            }
        });
        thread.setDaemon(true);
//        设置为true的话，主线程main一结束，子线程就结束
        thread.start();
        System.out.println("main is over");
    }
}
