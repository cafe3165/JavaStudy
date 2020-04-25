package J2SE.single;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class SingletonDou {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private static volatile SingletonDou singletonDou = null;

    private SingletonDou() {

    }

    public static SingletonDou getInstance() {
        if (singletonDou == null) {
            synchronized (SingletonDou.class) {
                if (singletonDou == null) {
                    singletonDou = new SingletonDou();
                }
            }
        }

        return singletonDou;
    }

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 5, 100, TimeUnit.MILLISECONDS, new SynchronousQueue<>(), new ThreadFactoryBuilder().build(), new ThreadPoolExecutor.AbortPolicy());
//        es.submit(() -> {
//            SingletonDou s=SingletonDou.getInstance();
//            s.setNum(s.getNum()+1);
//            System.out.println(s.getNum());
//        });
//        es.submit(() -> {
//            SingletonDou s=SingletonDou.getInstance();
//            s.setNum(s.getNum()+4);
//            System.out.println(s.getNum());
//
//        });
//
//        es.shutdown();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonDou s=SingletonDou.getInstance();
                System.out.println(s.getNum());
                s.setNum(s.getNum()+1);
                System.out.println(s.getNum());

            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonDou s=SingletonDou.getInstance();
                System.out.println(s.getNum());
                s.setNum(s.getNum()+5);
                System.out.println(s.getNum());

            }
        });
        es.submit(t1);
        es.submit(t2);
//        t1.start();
//        t2.start();


    }


}
