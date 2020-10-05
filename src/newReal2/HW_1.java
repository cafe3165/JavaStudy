package newReal2;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-28
 */
//        一条包含字母 A-Z 的消息通过以下方式进行了编码：
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
//        示例 1:
//        输入: "12"
//        输出: 2
//        解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
//        示例 2:
//        输入: "226"
//        输出: 3
//        解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
//        题目：

public class HW_1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        solve("2206");
        System.out.println(count);
    }

    static int count = 0;

    public static void solve(String num) {
        if (num.length() == 0) {
            count++;
            return;
        }
        if (num.length() > 0) {
            if(num.charAt(0) != 0){
                solve(num.substring(1));
            }
            if (num.length() > 1) {
                int curNum = Integer.parseInt(num.substring(0, 2));
                if (1 <= curNum && curNum <= 26){
                    solve(num.substring(2));
                }
            }
        }
    }


}
