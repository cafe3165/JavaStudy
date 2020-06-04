package leetcode_daily.May;

import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-05-28
 */
public class T394decodeString {
    private static Stack<Character> stack = new Stack<>();

    public static String decodeString(String s) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (isValid(chs[i]) || chs[i] == '[') {
                stack.push(chs[i]);
            } else {
                StringBuilder tmp = new StringBuilder();
                while (stack.peek() != '[') {
                    tmp.append(stack.pop());
                }
                tmp.reverse();
                //出栈左括号
                stack.pop();
                int num = 0, pos = 1;
                while (!stack.isEmpty() && stack.peek() <= '9' && stack.peek() >= '0') {
                    int n = stack.pop() - '0';
                    num += n * pos;
                    pos *= 10;
                }


                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < tmp.length(); k++) {
                        stack.push(tmp.charAt(k));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private static boolean isValid(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }


    public static void main(String[] args) {
        String str = "3[a]2[b4[F]c]";

        System.out.println(decodeString(str));

    }
}
