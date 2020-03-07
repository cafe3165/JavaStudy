package leetcode__interview;

/**
 * Author:cafe3165
 * Date:2020-03-03
 */
public class Top48rotate {
    public void rotate(int[][] matrix) {
//        转置
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <n ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
//        对称
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp=matrix[j][i];
                matrix[j][i]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Top48rotate t = new Top48rotate();
        t.rotate(matrix);
    }
}
