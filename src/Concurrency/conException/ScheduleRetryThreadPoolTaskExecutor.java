package Concurrency.conException;

import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Author:cafe3165
 * Date:2020-09-06
 */
public class ScheduleRetryThreadPoolTaskExecutor extends ScheduledThreadPoolExecutor {


    /**
     * @param corePoolSize     线程池核心数
     * @param taskTryMaxTimes  任务最大尝试次数
     * @param taskDelaySeconds
     * @param multiplier       If positive, then used as a multiplier for generating the next delay for taskTryMaxTimes
     */
    public ScheduleRetryThreadPoolTaskExecutor(int corePoolSize, int taskTryMaxTimes, int taskDelaySeconds, int multiplier) {
        super(corePoolSize);
        if (taskTryMaxTimes < 1) {
            throw new IllegalStateException("taskTryMaxTimes should gt 0");
        }
        this.taskTryMaxTimes = taskTryMaxTimes;
        this.taskDelaySeconds = taskDelaySeconds;
        if (multiplier <= 0) {
            throw new IllegalStateException("multiplier should gt 0");
        }
        this.multiplier = multiplier;
    }

    /**
     * 超时异常类列表
     */
    private static Set<String> RETRY_EXCEPTIONS = new HashSet<>();

    static {
        RETRY_EXCEPTIONS.add("java.net.SocketTimeoutException");
    }

    /**
     * 任务最大重试次数
     */
    private int taskTryMaxTimes;
    /**
     * 任务首次尝试延迟时间(单位秒)
     */
    private int taskDelaySeconds;
    /**
     * multiplier If positive, then used as a multiplier for generating the next delay for taskTryMaxTimes
     */
    private int multiplier;

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        TaskWithRetryFuture<?> future = (TaskWithRetryFuture) r;
        TaskExecuteInfo taskExecuteInfo = future.getTaskExecuteInfo();
        boolean retryRequest = taskExecuteInfo.getExecuteCount() > 1;
        t = getThrowable(r, t);
        if (t == null) {
            if (retryRequest) {
                print("任务:%s在重试%s次后成功", taskExecuteInfo.getRunable(), taskExecuteInfo.getExecuteCount() - 1);
            }
            return;
        }
        if (retryRequest) {
            if (taskExecuteInfo.getExecuteCount() > taskTryMaxTimes) {
                print("任务:%s重试最大次数，最大次数为%s，最后错误为%s", taskExecuteInfo.getRunable(), taskTryMaxTimes, t);
                return;
            }
        } else {
            print("首次提交重试任务");
        }

        Throwable cause = t;
        System.out.println(t.getStackTrace());
//        if (t instanceof TdopRuntimeException) {
//            TdopRuntimeException e = (TdopRuntimeException) t;
//            cause = e.getCause();
//        }
        print("执行失败，异常类为:%s", cause.getClass().getName());
        if (RETRY_EXCEPTIONS.contains(cause.getClass().getName())) {
            int delaySeconds = retryRequest ? taskExecuteInfo.getCurrentDelaySeconds() * multiplier
                    : taskExecuteInfo.getCurrentDelaySeconds();
            taskExecuteInfo.setCurrentDelaySeconds(delaySeconds);
            super.schedule(taskExecuteInfo, delaySeconds, TimeUnit.SECONDS);
        }
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        RunnableScheduledFuture<V> future = super.decorateTask(runnable, task);
        TaskWithRetryFuture<V> retryFuture = new TaskWithRetryFuture<V>((TaskExecuteInfo) runnable, future);
        return retryFuture;
    }


    private Throwable getThrowable(Runnable r, Throwable t) {
        if (t == null && r instanceof Future<?>) {
            try {
                Object result = ((Future<?>) r).get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        return t;
    }


    private static class TaskWithRetryFuture<V> implements RunnableScheduledFuture<V> {


        private RunnableScheduledFuture<V> runnableScheduledFuture;


        private TaskExecuteInfo taskExecuteInfo;


        public TaskWithRetryFuture(TaskExecuteInfo taskExecuteInfo, RunnableScheduledFuture<V> runnableScheduledFuture) {
            this.taskExecuteInfo = taskExecuteInfo;
            this.runnableScheduledFuture = runnableScheduledFuture;
        }


        @Override
        public void run() {
            runnableScheduledFuture.run();
            print("任务已跑%s次", taskExecuteInfo.getExecuteCount());
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return runnableScheduledFuture.getDelay(unit);
        }

        @Override
        public int compareTo(Delayed o) {
            return runnableScheduledFuture.compareTo(o);
        }

        @Override
        public boolean isPeriodic() {
            return runnableScheduledFuture.isPeriodic();
        }

        public TaskExecuteInfo getTaskExecuteInfo() {
            return taskExecuteInfo;
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return runnableScheduledFuture.cancel(mayInterruptIfRunning);
        }

        @Override
        public boolean isCancelled() {
            return runnableScheduledFuture.isCancelled();
        }

        @Override
        public boolean isDone() {
            return runnableScheduledFuture.isDone();
        }

        @Override
        public V get() throws InterruptedException, ExecutionException {
            return runnableScheduledFuture.get();
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return runnableScheduledFuture.get(timeout, unit);
        }


    }

    private static class TaskExecuteInfo implements Runnable {
        private Runnable runable;
        private int executeCount;
        private int currentDelaySeconds;


        public TaskExecuteInfo(Runnable runable, int currentDelaySeconds) {
            super();
            this.runable = runable;
            this.executeCount = 0;
            this.currentDelaySeconds = currentDelaySeconds;
        }

        public Runnable getRunable() {
            return runable;
        }

        public void setRunable(Runnable runable) {
            this.runable = runable;
        }

        public int getExecuteCount() {
            return executeCount;
        }

        public void setExecuteCount(int executeCount) {
            this.executeCount = executeCount;
        }

        public void increaseCount() {
            this.executeCount++;
        }

        public int getCurrentDelaySeconds() {
            return currentDelaySeconds;
        }

        public void setCurrentDelaySeconds(int currentDelaySeconds) {
            this.currentDelaySeconds = currentDelaySeconds;
        }

        @Override
        public void run() {
            increaseCount();
            runable.run();
            print("执行第%s次", executeCount);
        }

        @Override
        public String toString() {
            return "TaskExecuteInfo [runable=" + runable + ", executeCount=" + executeCount + ", currentDelaySeconds="
                    + currentDelaySeconds + "]";
        }
    }


    private static void print(String format, Object... args) {
        String msg = String.format(format, args);
        String date = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date());
        System.out.println(date + " " + msg);
    }


    public static void main(String[] args) throws InterruptedException {
        int taskTryMaxTimes = 5;
        int taskDelaySeconds = 2;
        int multiplier = 2;
        ScheduleRetryThreadPoolTaskExecutor retryThreadPoolTaskExecutor =
                new ScheduleRetryThreadPoolTaskExecutor(3, taskTryMaxTimes, taskDelaySeconds, multiplier);
        print("任务最大尝试次数为%s次,失败尝试时间为%s秒,时间间隔倍数为%s", taskTryMaxTimes, taskDelaySeconds, multiplier);
        int successTimes = 2;
        retryThreadPoolTaskExecutor.execute(
                new TaskExecuteInfo(() -> {
                    print("begin");
                    Random random = new Random();
                    int number = random.nextInt(3);
                    if (number != successTimes) {
                        print("执行失败");
                        throw new RuntimeException(new SocketTimeoutException("网络超时"));
                    }
                    print("执行成功");
                }, taskDelaySeconds)
        );

        Thread.sleep(5000);

    }


}
