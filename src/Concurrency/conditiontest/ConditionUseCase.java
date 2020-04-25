package Concurrency.conditiontest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class ConditionUseCase {
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void conditionWait() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            System.out.println(Thread.currentThread().getName() + "等待信号");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "拿到信号了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void conditionSignal() {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "拿到锁了");
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "发出信号");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public static void main(String[] args) {
        ConditionUseCase useCase = new ConditionUseCase();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @Override
            public void run() {
                useCase.conditionWait();
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                useCase.conditionSignal();
            }
        });

    }

}
