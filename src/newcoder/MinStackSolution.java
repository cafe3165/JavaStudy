package newcoder;

import java.util.Stack;

public class MinStackSolution {
    private static Stack<Integer> datastack = new Stack<Integer>();
    private static Stack<Integer> minstack = new Stack<Integer>();

    private static Integer minElement = Integer.MAX_VALUE;

    public void push(int node) {
        datastack.push(node);
        if (node < minElement || minstack.size() == 0) {
            minstack.push(node);
            minElement = node;
        } else {
            minstack.push(minstack.peek());

        }

    }

    public void pop() {

            datastack.pop();
            minstack.pop();


    }

    public int top() {
        return datastack.peek();
    }

    public int min() {
        return minstack.peek();
    }


    public static void main(String[] args) {
        MinStackSolution s = new MinStackSolution();

        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());



    }
}
