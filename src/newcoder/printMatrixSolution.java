package newcoder;

import java.util.ArrayList;

public class printMatrixSolution {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> seq = new ArrayList<>();
        int ColS = 0, ColE = matrix.length;
        int RowS = 0, RowE = matrix[0].length;
        int count = ColE * RowE;
        while (count > 0) {

            for (int i = RowS; i < RowE; i++) {
                seq.add(matrix[ColS][i]);
                count--;
            }
            ColS++;
            for (int i = ColS; i < ColE; i++) {
                seq.add(matrix[i][RowE - 1]);
                count--;
            }
            if(count==0)
                break;
            RowE--;
            for (int i = RowE - 1; i >= RowS; i--) {
                seq.add(matrix[ColE - 1][i]);
                count--;
            }
            ColE--;
            for (int i = ColE - 1; i >= ColS; i--) {
                seq.add(matrix[i][RowS]);
                count--;
            }
            RowS++;


        }

//        System.out.println(seq);
        return seq;


    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {0, 0, 0, 0}};
        int[][] matrix ={{1},{2},{3},{4},{5}};
        printMatrix(matrix);


    }
}
