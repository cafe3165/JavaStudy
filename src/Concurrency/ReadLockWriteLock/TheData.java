package Concurrency.ReadLockWriteLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
public class TheData {
    private Integer data = 0;
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public void get(){
        rwLock.readLock().lock();//读锁开启，读进程均可进入
        try{//用try finally来防止因异常而造成的死锁
            System.out.println(Thread.currentThread().getName()+"read lock is ready.."+sdf.format(new Date()));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"read data is"+data);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();//读锁解锁
        }
    }

    public void put(Integer data){
        rwLock.writeLock().lock();//写锁开启，这时只有一个写线程进入
        try{//用try finally来防止因异常而造成的死锁
            System.out.println(Thread.currentThread().getName()+"write lock is ready.."+sdf.format(new Date()));
            Thread.sleep(1000);
            this.data = data;
            System.out.println(Thread.currentThread().getName()+"write data is"+data);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();//写锁解锁
        }
    }
}
