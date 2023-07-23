package com.example.m;

/**
 * Author:cafe3165
 * Date:2023-04-22
 */
public class AL1 {

    public static boolean slove(int x) {
        if (x < 0) {
            return false;
        }
        int count = 0;
        int y = x;
        while (y > 0) {
            count++;
            y/=10;
        }

        return handle(x, count);

    }


    private static boolean handle(int x, int count) {
        if (count == 1 || count == 0) {
            return true;
        }
        int num = 1;
        int tmp = count;
        while (tmp > 1) {
            num*=10;
            tmp--;
        }
        int low = x % 10;
        int high = x / num;
        if (low != high) {
            return false;
        }
        return handle((x / 10) % num, count - 2);

    }

    public static void main(String[] args) {
        System.out.println(slove(121));
        System.out.println(slove(-121));
        System.out.println(slove(1));
        System.out.println(slove(0));
        System.out.println(slove(-1));
        System.out.println(slove(10));
    }
}
