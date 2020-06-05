package leetcode_daily.June;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class M29spiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;


        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[up][i];
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                res[index++] =(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] =(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                res[index++] =(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}

        };
        spiralOrder(matrix);
    }
}
