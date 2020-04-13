package Real;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-04-12
 */
public class kuaishou1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rex = sc.next();
        solve(rex);
    }

    public static void solve(String rex) {
        Stack<Character> stack = new Stack<>();
        char[] reschs = rex.toCharArray();
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 0; i < reschs.length; i++) {
            char c = reschs[i];
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()&&stack.peek() == '(' && c == ')') {
                n1++;
                stack.pop();
                continue;
            }
            if (c == ')') {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                n2++;
            } else {
                n3++;
            }
        }
        System.out.println(n1 + " " + n2 + " " + n3);

//        System.out.println(rex);
    }
}
