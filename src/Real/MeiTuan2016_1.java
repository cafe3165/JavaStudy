package Real;

/**
 * Author:cafe3165
 * Date:2020-03-31
 */
public class MeiTuan2016_1 {
    public int getDis(int[] A, int n) {
        // write code here
        if (n == 1 || n == 0) {
            return 0;
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res=Math.max(A[j]-A[i],res);
            }
        }


        return res;
    }
}
