package Real;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-26
 */
public class tencent2 {
    public static class q {
        public int maxSize;
        public int f;
        public int r;
        public int[] queue;
        public q(int maxSize) {
            f = -1;
            r = -1;
            this.maxSize = maxSize;
            queue = new int[maxSize];
        }
        public boolean isEmpty() {
            return r == f;
        }
        public void push(int data) {
            r++;
            queue[r] = data;
        }
        public int  top() {
            if (isEmpty()) {
                return -1;
            } else {
                return queue[f+1];
            }
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            } else {
                f++;
                return queue[f];
            }
        }
        public int size() {
            return r - f;
        }
        public void clear() {
            while(f<r){
                queue[f]=0;
                f++;
            }
            f=-1;
            r=-1;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int Q = sc.nextInt();
            q queue = new q(1005);
            for (int j = 0; j < Q; j++) {
                String op = sc.next();
                switch (op) {
                    case "PUSH":
                        queue.push(sc.nextInt());
                        break;
                    case "TOP":
                        System.out.println(queue.top());
                        break;
                    case "POP":
                        if(queue.pop()==-1){
                            System.out.println(-1);
                        }
                        break;
                    case "SIZE":
                        System.out.println(queue.size());
                        break;
                    case "CLEAR":
                        queue.clear();
                        break;
                    default:
                        break;
                }
            }
        }

    }
}

//        2
//        7
//        PUSH 1
//        PUSH 2
//        TOP
//        POP
//        TOP
//        POP
//        POP
//        5
//        PUSH 1
//        PUSH 2
//        SIZE
//        POP
//        SIZE