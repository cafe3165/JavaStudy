package Real;

/**
 * Author:cafe3165
 * Date:2020-05-10
 */
public class ali_0510 {
    public static int solve(int[] a, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j + 1] < a[j]) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a[a.length-k];
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 8, 2, 4, 7, 5};
        int k = 3;
        int res = solve(a, k);
        System.out.println(res);
    }
}
