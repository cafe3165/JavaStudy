package leetcode_daily;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-05-14
 */
public class T155MinStack {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    public T155MinStack() {
        stack = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        pq.offer(x);
    }

    public void pop() {
        int x = stack.pop();
        Iterator<Integer> it=pq.iterator();
        while (it.hasNext()){
            if(it.next()==x){
                it.remove();
                break;
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }

    public static void main(String[] args) {
        T155MinStack t = new T155MinStack();
        t.push(0);
        t.push(1);
        t.push(0);
        System.out.println(t.getMin());
        t.pop();
//        System.out.println(t.top());
        System.out.println(t.getMin());

    }
}
