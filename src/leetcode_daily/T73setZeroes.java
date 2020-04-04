package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class T73setZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((matrix[i][j] & 1) == 0) {
                    set(i, j, matrix);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = matrix[i][j] >> 1 > 1 ? 0 : 1;
            }
        }

//        System.out.println(matrix);
    }


    public void setZeroes2(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void set(int I, int J, int[][] matrix) {
//        rows
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[I][i] |= 0b10;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][J] |= 0b10;
        }

    }

    public static void main(String[] args) {
        T73setZeroes t = new T73setZeroes();
        int[][] matrix = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        t.setZeroes(matrix);
    }
}
