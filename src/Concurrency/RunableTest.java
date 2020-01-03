package Concurrency;
import	java.util.concurrent.FutureTask;

import java.util.concurrent.Callable;

public class RunableTest {
    public static class RunableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("555");
        }
    }

    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception{
            return "hello";
        }

    }


    public static void main(String[] args) throws InterruptedException {

        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();

        FutureTask<String> futureTask = new FutureTask<> (new CallerTask());
        new Thread(futureTask).start();
        try{
            String result=futureTask.get();
            System.out.println(result);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
