package leetcode_daily.May;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-05-27
 */
public class T974subarraysDivByK {
    public static int subarraysDivByK2(int[] A, int K) {
        int len = A.length;
        int res=0;
        int[] pre = new int[len + 1];
        pre[0] = 0;
        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + A[i];
        }

        for (int i = 0; i <= len; i++) {
            for (int j = i+1; j <= len; j++) {
                int tmp=pre[j]-pre[i];
                if(tmp%K==0){
                    res++;
                }
            }

        }

        return res;
    }

    public static int subarraysDivByK(int[] A, int K){
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        int k = 5;
        subarraysDivByK(A, k);

    }
}
