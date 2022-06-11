package com.example.leetcode.labuladong.DataStruct;

import java.util.Deque;
import java.util.LinkedList;

public class T239maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < len; i++) {
            if (i < k - 1) {
                myQueue.push(nums[i]);
            } else {
                myQueue.push(nums[i]);
                res[index++] = myQueue.max();
                myQueue.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int num) {
            while(!deque.isEmpty() && deque.peekLast() < num){
                deque.pollLast();
            }
            deque.addLast(num);
        }

        public int max() {
            return deque.peekFirst();
        }

        public void pop(int num) {
            if(!deque.isEmpty() && num == deque.peekFirst()){
                deque.pollFirst();
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
