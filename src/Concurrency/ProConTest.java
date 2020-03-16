package Concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-03-13
 */
public class ProConTest {
    public static void main(String[] args) {
        BlockingQueue bq = new LinkedBlockingQueue<>();
        Thread pro = new Thread(new Producer(bq));
        Thread con = new Thread(new Consumer(bq));
        Thread con2=new Thread(new Consumer(bq));
        pro.start();
        con.start();
        con2.start();
    }
}
