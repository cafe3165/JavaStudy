package Concurrency.cachedQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */

public class DoubleBlockingQueue<T> {
    private volatile boolean direction = true;
    private List<T> queue1 = new LinkedList<>();
    private List<T> queue2 = new LinkedList<>();
    private Object readLock = new Object();
    private Object writeLock = new Object();
    public void add(T o) {
        synchronized (readLock) {
            if (direction) {
                queue1.add(o);
            } else {
                queue2.add(o);
            }
        }
    }

    public T poll() {
        synchronized (writeLock) {
            if (direction) {
                return unqueue(queue2, queue1);
            }
            return unqueue(queue1, queue2);
        }
    }

    private T unqueue(List<T> poll, List<T> put) {
        if (poll.isEmpty()) {
            synchronized (readLock) {
                if (put.isEmpty())
                    return null;
                direction = !direction;
            }
            return put.remove(0);
        } else {
            return poll.remove(0);
        }
    }
}
