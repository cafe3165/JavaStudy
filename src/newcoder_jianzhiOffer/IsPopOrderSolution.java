package newcoder_jianzhiOffer;

import java.util.Stack;

public class IsPopOrderSolution {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int PopIndex = 0, PushIndex = 0;
        boolean f = true;

        while (PushIndex < pushA.length) {
            if ((pushA[PushIndex] != popA[PopIndex])) {
                stack.push(pushA[PushIndex]);
                PushIndex++;
            } else {
//                stack.pop();
                PushIndex++;
                PopIndex++;

            }

        }

//        System.out.println(stack);
        while((!stack.empty())&&PopIndex<PushIndex){
            if(stack.peek()==popA[PopIndex]){
                stack.pop();
                PopIndex++;
                f=true;
            }
            else
                return false;
        }

        return f;


    }

    public static void main(String[] args) {
//        int[] A = {1, 2, 3, 4, 5};
//        int[] C = {4, 3, 5, 1, 2};
//        int[] B = {4, 5, 3, 2, 1};
        int[] A = {1};
        int[] B={1};

        System.out.println(IsPopOrder(A, B));
//        IsPopOrder(A, C);
    }
}
