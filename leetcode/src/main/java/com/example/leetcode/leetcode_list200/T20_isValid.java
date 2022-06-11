package com.example.leetcode.leetcode_list200;

import java.util.HashMap;
import java.util.Stack;

public class T20_isValid {


    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        T20_isValid t = new T20_isValid();
        t.isValid("[]}");
    }
}
