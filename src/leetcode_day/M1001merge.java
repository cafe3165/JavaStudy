package leetcode_day;

/**
 * Author:cafe3165
 * Date:2020-03-03
 */
public class M1001merge {
    public void merge(int[] A, int m, int[] B, int n) {

        int[] sorted = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (true) {
            if (i < m && j < n) {
                if (A[i] < B[j]) {
                    sorted[k++] = A[i++];
                } else {
                    sorted[k++] = B[j++];
                }
            } else {
                break;
            }

        }
        while (i != m) {
            sorted[k++] = A[i++];
        }
        while (j != n) {
            sorted[k++] = B[j++];

        }
        for (int l = 0; l < sorted.length; l++) {
            A[l]=sorted[l];
        }
//        A=sorted.clone();

    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0}, B = {2, 5, 6};
        int m = 3, n = 3;
        M1001merge M = new M1001merge();
        M.merge(A, m, B, n);
    }

}
