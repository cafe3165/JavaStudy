package Concurrency.Queue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Author:cafe3165
 * Date:2020-04-23
 */
@Data
public class people implements Delayed {
    private String name;
    private String id;
    private long endTime;

    public people(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return endTime - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        people p = (people) o;
        return endTime - p.endTime > 0 ? 1 : 0;
    }
}
