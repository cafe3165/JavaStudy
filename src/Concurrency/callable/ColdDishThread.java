package Concurrency.callable;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class ColdDishThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
