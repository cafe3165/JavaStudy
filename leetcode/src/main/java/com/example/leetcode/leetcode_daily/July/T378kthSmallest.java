package com.example.leetcode.leetcode_daily.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T378kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        int ind = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[ind++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];

    }

    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];

            }
        });
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
//        new int[] {a,b,c}
//        a:matrix[b][c]
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != matrix.length - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }


        return pq.poll()[0];
    }

    public int kthSmallest3(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];
        while (low <= high) {
            int midVal = low + (high - low) / 2;
            int count = countK(matrix, midVal);
            if (count < k) {
                low = midVal + 1;
            } else {
                high = midVal - 1;
            }
        }
        return low;
    }

    private int countK(int[][] matrix, int midVal) {
        int count = 0;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (midVal >= matrix[row][col]) {
                count += (col + 1);
                row++;
            } else {
                col--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 14},
                {12, 13, 15}
        };
        int k = 8;
        T378kthSmallest t = new T378kthSmallest();
        System.out.println(t.kthSmallest3(matrix, k));
    }
}
