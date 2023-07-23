package com.example.m;

import javafx.concurrent.Worker;

import java.util.*;
import java.util.concurrent.*;

/**
 * Author:cafe3165
 * Date:2023-04-01
 */
public class HW_4 {

    static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[][] solve(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>(intervals.length);
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(intervalList, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o2.end - o1.end;
            }
            return o1.start - o2.start;
        });
        Interval curInterval = null;
        List<Interval> resList = new ArrayList<>();
        for (Interval interval : intervalList) {
            if (curInterval == null) {
                curInterval = interval;
                continue;
            }
            if (curInterval.end >= interval.end || curInterval.end >= interval.start) {
                curInterval.end = interval.end;
                continue;
            }

            if (curInterval.end < interval.start) {
//                resList.add(new Interval(curInterval.start, curInterval.end));
                resList.add(curInterval);
                curInterval = interval;
            }

        }
        if (curInterval != null) {
            resList.add(new Interval(curInterval.start, curInterval.end));
        }
        int[][] res = new int[resList.size()][2];
        int index = 0;
        for (Interval interval : resList) {
            res[index][0] = interval.start;
            res[index][1] = interval.end;
            index++;
        }
        resList.remove(curInterval);

        return res;
    }


    public static void main(String[] args) {
//        int[][] test = new int[][]{{1,4},{4,5}};
        int[][] test = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = HW_4.solve(test);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
//        Collections.sort();
//        HashMap map = new HashMap();
//        map.put();
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put();
//        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//        threadLocal.set(1);
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
//        executor.execute();
//        executor.setCorePoolSize();
//        executor.getQueue().size();
//        ArrayBlockingQueue<Interval> q = new ArrayBlockingQueue<>();
//        q.offer();
//        q.poll();
//        q.put();
//        q.take();
//        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
//        linkedBlockingQueue.offer();
//        linkedBlockingQueue.put();
//        linkedBlockingQueue.take();
//        SynchronousQueue synchronousQueue = new SynchronousQueue();
//        synchronousQueue.put();
//        DelayQueue delayQueue = new DelayQueue();
//        delayQueue.put();

    }
}
