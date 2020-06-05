package leetcode_list200;

import J2SE.codeblock.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T43multiply {
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        List<List<Character>> slist = new ArrayList<>();
        for (int i = n2.length - 1; i >= 0; i--) {
            char[] tmp = mul(n1, n2[i]).toCharArray();
            List<Character> t = new ArrayList<>();
            for (char c : tmp) {
                t.add(c);
            }
            for (int j = 0; j < n2.length - i - 1; j++) {
                t.add('0');
            }
            slist.add(t);

        }
        String res = add(slist);

        return res;
    }

    private static String mul(char[] a, char b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int tmp = (a[i] - '0') * (b - '0') + carry;
            carry = tmp / 10;
            int num = tmp % 10;
            sb.append(num);
        }

        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private static String add(List<List<Character>> nums) {
        List<Character> res = new ArrayList<>();
        res.add('0');
        for (int i = 0; i < nums.size(); i++) {
            res = addTwo(res, nums.get(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : res) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static List<Character> addTwo(List<Character> a, List<Character> b) {
        int index1 = a.size() - 1, index2 = b.size() - 1;
        List<Character> res = new ArrayList<>();
        int carry = 0;
        while (index1 >= 0 && index2 >= 0) {
            int num1 = a.get(index1) - '0';
            int num2 = b.get(index2) - '0';
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int tmp = sum % 10;
            res.add((char) (tmp + '0'));
            index1--;
            index2--;
        }

        while (index2 >= 0) {
            int sum = b.get(index2)-'0' + carry;
            if (sum > 9) {
                res.add('0');
                res.add('1');
                index2--;
                carry=0;
                continue;
            }
            res.add((char)(sum+'0'));
            index2--;
            carry=0;
        }
        if(carry!=0){
            res.add('1');
        }


        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        String num1 = "3", num2 = "38";

        System.out.println(multiply(num1, num2));
    }
}
