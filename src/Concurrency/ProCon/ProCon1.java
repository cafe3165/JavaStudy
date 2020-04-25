package Concurrency.ProCon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class ProCon1 {
    public static void main(String[] args) {
        BlockingQueue shareQueue = new LinkedBlockingQueue<>();
        Thread pro = new Thread(new Producer1(shareQueue));
        Thread con = new Thread(new Consumer1(shareQueue));
        pro.start();
        con.start();
        System.out.println(Thread.activeCount());
    }
}
