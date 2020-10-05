package NewReal;

import J2SE.codeblock.C;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author:cafe3165
 * Date:2020-09-15
 */
public class XM_1 {
    static Map<Character, Character> map;

    public static boolean judge(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() %2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()||stack.peek()!=map.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            String s = sc.nextLine();
            System.out.println(judge(s));
        }
    }
}
