package com.example.leetcode.leetcode_daily.March;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-22
 */
public class T945minIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            while(A[i]<=A[i-1]){
                A[i]++;
                res++;
            }
        }



        return res;

    }

    public static void main(String[] args) {
        T945minIncrementForUnique t = new T945minIncrementForUnique();
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        System.out.println(s.length);
        int[] A = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            A[i] = Integer.parseInt(s[i]);
        }
        t.minIncrementForUnique(A);


    }


}
