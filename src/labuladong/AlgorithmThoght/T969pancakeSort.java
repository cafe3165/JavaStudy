package labuladong.AlgorithmThoght;

import java.util.ArrayList;
import java.util.List;

public class T969pancakeSort {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        sort(res, A, A.length - 1);
        return res;
    }


    public void sort(List<Integer> res, int[] A, int end) {
        if (end == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int id = 0;
        for (int i = 0; i <= end; i++) {
            if (A[i] > max) {
                id = i;
                max = A[i];
            }
        }
        reverse(A, id);
        res.add(id+1);
        reverse(A, end);
        res.add(end+1);
        sort(res, A, end - 1);

    }

    public void reverse(int[] A, int n) {
        int l = 0, r = n;
        while (l < r) {
            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 4, 1};
        T969pancakeSort t = new T969pancakeSort();
        t.pancakeSort(A);
//        t.reverse(A,3);
        System.out.println(A);
    }
}
