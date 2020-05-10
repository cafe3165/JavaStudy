package Concurrency;

/**
 * Author:cafe3165
 * Date:2020-05-04
 */
public class maxthredtest {
    public static void main(String[] args) {
        Thread[] ts=new Thread[10000];

        for (int i = 0; i < 10000; i++) {

            Thread thread=new Thread(() -> System.out.println(1));
            ts[i]=thread;
//            thread.start();
        }
    }
}
