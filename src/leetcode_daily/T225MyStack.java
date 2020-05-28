package leetcode_daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2020-05-25
 */
public class T225MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public T225MyStack() {
        queue=new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.offer(queue.poll());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();

    }

    /** Get the top element. */
    public int top() {
        return queue.peek();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        T225MyStack stack=new T225MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
