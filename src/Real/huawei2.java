package Real;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-04-29
 */
public class huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
//        babcaa 2
        System.out.println(solve(str, k));
    }

    public static String solve(String str, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int popNum = 0;
        for (int i = 0; i < chs.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chs[i]);
            } else {
                while (!stack.isEmpty()&&stack.peek() > chs[i] && popNum < k) {
                    stack.pop();
                    popNum++;
                }
                stack.push(chs[i]);

//                stack.push(chs[i]);

            }
        }
        while (popNum < k) {
            stack.pop();
            popNum++;
        }


        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
