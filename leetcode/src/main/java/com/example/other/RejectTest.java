package com.example.other;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author:cafe3165
 * Date:2023-03-11
 */
public class RejectTest {
    public static void main(String[] args) {
        // 自定义的线程池任务拒绝策略
//        RejectedExecutionHandler rejected = (Runnable r, ThreadPoolExecutor executor) -> {
//            if (r instanceof RunnableImpl) {
//                RunnableImpl rm = (RunnableImpl) r;
//                Print.outln("线程任务被拒绝 : " + rm.id);
//                try {
//                    // 等待1.5秒后，尝试将当前被拒绝的任务重新加入线程队列
//                    // 此时主线程是会被阻塞的
//                    Thread.sleep(1500);
//                    Print.outln("尝试重新加入 : " + rm.id);
//                    executor.execute(r);
//                } catch (Exception e) {
//                }
//            }
//        }

//            LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(1);


            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("thread");
                } catch (Exception e) {

                }
            });
            t.start();

        System.out.println("main");



        }


}
