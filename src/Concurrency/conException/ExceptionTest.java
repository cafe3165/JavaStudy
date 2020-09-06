package Concurrency.conException;

/**
 * Author:cafe3165
 * Date:2020-09-06
 */
public class ExceptionTest {
    static class Task implements Runnable {

        @Override
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
            System.out.println(Integer.parseInt("123"));
            System.out.println(Integer.parseInt("223"));
            System.out.println(Integer.parseInt("1t2"));
            System.out.println(Integer.parseInt("133"));
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
    }
}
class ExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getState());
    }
}
