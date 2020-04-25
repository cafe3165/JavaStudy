package Concurrency.callable;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class BumThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000*3);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}