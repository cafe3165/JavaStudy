package com.example.leetcode.leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-11
 */
public class T1013canThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        int l = A.length;
        for (int i = 0; i < l; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int i = 0, cur = 0;
        while (i < l) {
            cur += A[i];
            if (cur == target) {
                break;
            }
            i++;
        }
        int j = i + 1;
        while (j+1 < l) {
            cur += A[j];
            if (cur == target * 2) {
                return true;
            }
            j++;
        }

        return false;


    }

    public static void main(String[] args) {
        T1013canThreePartsEqualSum t = new T1013canThreePartsEqualSum();
        int[] A = {1,-1,1,-1};
        t.canThreePartsEqualSum(A);
    }
}
