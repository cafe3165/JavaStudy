package Concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Author:cafe3165
 * Date:2020-03-17
 */
public class countdowntest {
    public static void main(String[] args) {
        ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService service = new ThreadPoolExecutor(1, 4, 300, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), tf, new ThreadPoolExecutor.AbortPolicy());
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
                        cdOrder.await();
                        System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                        cdAnswer.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判" + Thread.currentThread().getName() + "即将发布口令");
            cdOrder.countDown();
            System.out.println("裁判" + Thread.currentThread().getName() + "已发送口令，正在等待所有选手到达终点");
            cdAnswer.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判" + Thread.currentThread().getName() + "汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
