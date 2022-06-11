package com.example.leetcode.leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-10-17
 */
public class T977sortedSquares {

    public static int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int start = 0, l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 && A[i] >= 0) {
                l = -1;
                r = 0;
                break;
            }
            if (i == 0 && A[len - 1] <= 0) {
                l = len - 1;
                r = len;
                break;
            }
            if (i + 1 < len && A[i] < 0 && A[i + 1] >= 0) {
                l = i;
                r = i + 1;
                break;
            }
        }
        while (l >= 0 && r < len) {
            int L, R;
            L = Math.abs(A[l]);
            R = Math.abs(A[r]);
            if (L > R) {
                res[start++] = (int) Math.pow(R, 2);
                r++;
            } else {
                res[start++] = (int) Math.pow(L, 2);
                l--;
            }
        }
        while (l >= 0) {
            res[start++] = (int) Math.pow(A[l], 2);
            l--;
        }
        while (r < len) {
            res[start++] = (int) Math.pow(A[r], 2);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {-7,-3,2,3,11};
        int[] res = sortedSquares(A);
        System.out.println(res);

    }
}
