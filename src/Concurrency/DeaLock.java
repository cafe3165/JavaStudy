package Concurrency;

import lombok.Data;
import lombok.SneakyThrows;

/**
 * Author:cafe3165
 * Date:2020-04-25
 */
@Data
public class DeaLock {
    public  Integer a;
    public  Integer b;

    public DeaLock(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }
    public static void main(String[] args) {
        DeaLock dl = new DeaLock(1, 2);
        Thread t1 = new Thread(() -> {
            synchronized (dl.a){
                System.out.println(dl.a);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (dl.b){
                    System.out.println(dl.b);
                }

            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (dl.b){
                System.out.println(dl.b);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (dl.a){
                    System.out.println(dl.a);
                }
            }
        });
        t1.start();
        t2.start();
    }
}
