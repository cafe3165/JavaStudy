package Concurrency.ThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.Uninterruptibles;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.concurrent.*;

@Data
@Log4j
public class ThreadPoolTest {
    static int DEFAULT_QUEUE_SIZE = 3;
    static int DEFAULT_CORE_POOL_SIZE = 3;
    static int DEFAULT_MAX_POOL_SIZE = 5;

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(DEFAULT_QUEUE_SIZE);
        ThreadPoolExecutor statisticsThreadPool = new ThreadPoolExecutor(DEFAULT_CORE_POOL_SIZE, DEFAULT_MAX_POOL_SIZE,
                60, TimeUnit.SECONDS, queue, new ThreadFactoryBuilder()
                .setThreadFactory(new ThreadFactory() {
                    private int count = 0;
                    private String prefix = "StatisticsTask";

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, prefix + "-" + count++);
                    }
                }).setUncaughtExceptionHandler((t, e) -> {
                    String threadName = t.getName();
//                    log.error("statisticsThreadPool error occurred! threadName: {}, error msg: {}", threadName, e.getMessage(), e);
                }).build(), (r, executor) -> {
            if (!executor.isShutdown()) {
//                logger.warn("statisticsThreadPool is too busy! waiting to insert task to queue! ");
                Uninterruptibles.putUninterruptibly(executor.getQueue(), r);
            }
        }) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t == null && r instanceof Future<?>) {
                    try {
                        Future<?> future = (Future<?>) r;
                        future.get();
                    } catch (CancellationException ce) {
                        t = ce;
                    } catch (ExecutionException ee) {
                        t = ee.getCause();
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt(); // ignore/reset
                    }
                }
                if (t != null) {
//                    logger.error("statisticsThreadPool error msg: {}", t.getMessage(), t);
                }
            }
        };
        statisticsThreadPool.prestartAllCoreThreads();
        statisticsThreadPool.getActiveCount();

    }
}
