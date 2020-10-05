package leetcode__interview;

/**
 * Author:cafe3165
 * Date:2020-09-27
 */
public class count1 {
    public static void main(String[] args) {
        int a = 13;
        int b = 7;
        int n = a & b;
        int count = 0;
        while (n > 0) {
            n &= n - 1;
            count++;
        }
        System.out.println(count);
    }
}
