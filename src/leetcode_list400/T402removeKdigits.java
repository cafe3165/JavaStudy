package leetcode_list400;

import java.util.Stack;

public class T402removeKdigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int len = num.length();
        if (len == k) {
            return "0";
        }

        for (int i = 0; i < len; i++) {
            Character cur = num.charAt(i);
            while (!stack.isEmpty() && cur - '0' < stack.peek() - '0' && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        int zero = 0;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '0') {
                zero++;
            } else {
                break;
            }
        }
        res = res.substring(zero);
        return res.isEmpty() ? "0" : res;
    }

    public static void main(String[] args) {
//        String num = "1432219";
        String num = "10";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }
}
