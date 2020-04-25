package Concurrency.ProCon;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class ProCon2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> quque=new PriorityQueue<>();
        Consumer2 con=new Consumer2(quque);
        Producer2 pro=new Producer2(quque);
        con.start();
        pro.start();
    }
}
