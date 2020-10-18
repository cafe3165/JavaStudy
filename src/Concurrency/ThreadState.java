package Concurrency;


import javafx.scene.control.TableColumn;

import java.util.concurrent.locks.LockSupport;

public class ThreadState {
    static Object o = new Object();

    static class Task implements Runnable {
        User user = new User();
        @Override
        public void run() {
            user.getAge();
        }
    }
    static class User {
        int age = 0;
        public  synchronized void getAge(){
            age++;
            while (true);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);



        t1.start();
        t2.start();
//        LockSupport.park(t1);
//        while (true);
//        LockSupport.unpark(t2);
//        t1.join();
        //t2.wait();
    }
}
