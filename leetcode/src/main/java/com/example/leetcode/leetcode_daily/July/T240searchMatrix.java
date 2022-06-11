package com.example.leetcode.leetcode_daily.July;

import java.util.Arrays;

public class T240searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
//        没啥用的做法
        int m = matrix.length, n = matrix[0].length;
        int id = 0;
        int[] a = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[id++] = matrix[i][j];
            }
        }
        Arrays.sort(a);
        return Arrays.binarySearch(a, target) < 0 ? false : true;

    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T240searchMatrix t = new T240searchMatrix();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        t.searchMatrix(matrix, target);
        System.out.println();


    }

}
