package Concurrency.Queue;

import java.util.concurrent.DelayQueue;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class netbar implements Runnable {
    private DelayQueue<people> queue = new DelayQueue<>();
    public boolean work = true;

    public void login(String name, String id, int money) {
        people p = new people(name, id, 1000 * 60 * money + System.currentTimeMillis());
        System.out.println(p.getName() + " 钱" + money);
        queue.add(p);
    }

    public void shut(people p) {

        System.out.println(p.getName() + " " + p.getId());
    }

    @Override
    public void run() {
        while(work){
            try{
                System.out.println("check");
                people p=queue.take();
                shut(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        netbar n=new netbar();
        Thread netsuf=new Thread(n);
        netsuf.start();
        for (int i = 0; i < 5; i++) {
            n.login(String.valueOf(i),String.valueOf(i),i);
        }

    }
}
