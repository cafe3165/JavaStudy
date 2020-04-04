package Concurrency;

/**
 * Author:cafe3165
 * Date:2020-03-31
 */
public class outTest {
    public static void main(String args[]) {
        Thread t = new Thread() {
            @Override
            public void run() {
                ping();
                pong();
            }
        };
        t.start();
//        System.out.print("ping");
    }
    static void ping(){
        System.out.println("ping");
    }
    static void pong() {
        System.out.print("pong");
    }

}
