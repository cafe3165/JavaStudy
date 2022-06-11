package com.example.leetcode.leetcode_list200;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/4 5:57 下午
 */
public class T59generateMatrix {
    int[] bound = new int[4];

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int d = 0;
        bound[0] = n - 1;//右
        bound[1] = n - 1;//下
        bound[2] = 0;//左
        bound[3] = 0;//上
        int num = 1;
        while (num <= n * n) {
            print(matrix);
            int r , c;
            switch (d % 4) {
                case 0:
                    c = bound[2];
                    while (c <= bound[0]) {
                        matrix[bound[3]][c] = num++;
                        c++;
                    }
                    bound[3]++;
                    d++;
                    break;
                case 1:
                    r = bound[3];
                    while (r <= bound[1]) {
                        matrix[r][bound[0]] = num++;
                        r++;
                    }
                    bound[0]--;
                    d++;
                    break;
                case 2:
                    c = bound[0];
                    while (c >= bound[2]) {
                        matrix[bound[1]][c] = num++;
                        c--;
                    }
                    bound[1]--;
                    d++;
                    break;
                case 3:
                    r = bound[1];
                    while (r >= bound[3]) {
                        matrix[r][bound[2]] = num++;
                        r--;
                    }
                    bound[2]++;
                    d++;
                    break;
                default:
                    break;
            }
        }

        return matrix;
    }

    public void print (int[][] matrix) {
        int l = matrix.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }




    public static void main(String[] args) {
        int n = 3;
        T59generateMatrix t59generateMatrix = new T59generateMatrix();
        t59generateMatrix.generateMatrix(n);
    }
}
