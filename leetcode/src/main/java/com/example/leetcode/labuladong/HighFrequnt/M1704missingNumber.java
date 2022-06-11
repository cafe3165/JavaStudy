package com.example.leetcode.labuladong.HighFrequnt;

/**
 * Author:cafe3165
 * Date:2020-08-01
 */
public class M1704missingNumber {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int res=0;
        res^=len;
        for (int i = 0; i < len; i++) {
            res^=nums[i]^i;
        }
        return res;
    }
    public static void main(String[] args) {
        M1704missingNumber m=new M1704missingNumber();
        m.missingNumber(new int[]{3,0,1});

    }
}
