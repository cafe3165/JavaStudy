package Concurrency;

/**
 * Author:cafe3165
 * Date:2020-09-26
 */
public class JoinTest {
    public static void main(String[] args){
        System.out.println("MainThread run start.");

        //启动一个子线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadA run start.");
                System.out.println("threadA run finished.");
            }
        });
        threadA.start();

        System.out.println("MainThread join before");

        System.out.println("MainThread run finished.");
    }
}
