package newcoder;

import java.util.Arrays;

public class GetNumberOfKSolution {
    public int GetNumberOfK(int[] array, int k) {
        int index = Arrays.binarySearch(array, k);
        int count = 0;
        if (index < 0) return 0;

        for (int i = index; i < array.length && array[i] == k; i++) {
            count++;
        }
        for (int i = index - 1; i >= 0 && array[i] == k; i--) {
            count++;
        }

//        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        GetNumberOfKSolution g = new GetNumberOfKSolution();
        int[] array = {13, 35, 2, 4, 6, 6, 6, 6, 6, 2, 2, 2, 0};
        Arrays.sort(array);
        int k = 6;
        g.GetNumberOfK(array, k);
    }
}
