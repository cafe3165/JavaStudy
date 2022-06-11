package com.example.leetcode.leetcode_daily.March;

import java.util.ArrayList;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */
public class M59MaxQueue {
    ArrayList<Integer> queue1 = null;
    ArrayList<Integer> queue2 = null;

    public M59MaxQueue() {
        queue1 = new ArrayList<>();
        queue2 = new ArrayList<>();
    }

    public int max_value() {
        if (queue2.size() == 0) {
            return -1;
        }
        return queue2.get(0);
    }

    public void push_back(int value) {
//        便于queue2为空时的判断
//        一定要用while，用来清空queue2不能用if

        while(!queue2.isEmpty() && value >= queue2.get(queue2.size() - 1)) {
            queue2.remove(queue2.size() - 1);
        }
        queue2.add(value);
        queue1.add(value);

    }

    public int pop_front() {
        if (queue1.size() == 0) {
            return -1;
        }
        int tmp = queue1.get(0);
        if (queue2.get(0) == tmp) {
            queue2.remove(0);
        }
        queue1.remove(0);
        return tmp;
    }

    public static void main(String[] args) {
        M59MaxQueue m = new M59MaxQueue();
        m.push_back(94);
        m.push_back(16);
        m.push_back(89);

//        System.out.println(m.max_value());
        System.out.println(m.pop_front());
        m.push_back(22);
        System.out.println(m.pop_front());
//        System.out.println(m.max_value());
    }
}
