package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-04-07
 */
public class M107rotate {
    public void rotate(int[][] matrix) {
//        转置
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
//        交换
        for (int i = 0; i < c / 2; i++) {
            for (int j = 0; j < r; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][c - i - 1];
                matrix[j][c - i - 1] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        M107rotate m = new M107rotate();
        m.rotate(matrix);
    }
}
