package leetcode_daily;

import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public class T739_ddz_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        if (len == 0) {
            return new int[]{};
        }
        if (len == 1) {
            return new int[]{0};
        }
        stack.push(0);
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int tmp = stack.pop();
                res[tmp] = i - tmp;
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        T739_ddz_dailyTemperatures t = new T739_ddz_dailyTemperatures();
        t.dailyTemperatures(T);

    }
}
