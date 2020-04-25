package Concurrency.order;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class countdownlatchtest {

    static class child extends Thread {
        private int id;
        private CountDownLatch countDownLatch;

        public child(int id, CountDownLatch countDownLatch) {
            this.id = id;
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt(5000)));
                System.out.println(String.format("child thread %d",id));
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }

        }


    }


    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new child(i,countDownLatch).start();
        }
        try {
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("main end");
        }



    }
}
