package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-12
 */
public class kuaishou2 {
    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     *
     * @param R int整型
     * @param N int整型 N进制
     * @return int整型一维数组
     */
    public static int[] GetPowerFactor(int R, int N) {
        int M = 1;
        int[] RES = null;
        if (N == 0 || N == 1) {
            return new int[]{};
        }
        if (R == 0) {
            return new int[]{};
        }
        if (R == 1) {
            return new int[]{0};
        }

        // write code here
        List<Integer> nm = new ArrayList<>();
        while (R >= M) {
            nm.add(M);
            M *= N;

        }
        List<Integer> res = new ArrayList<>();
        for (int i = nm.size() - 1; i >= 0; i--) {
            if (R >= nm.get(i)) {
                res.add(i);
                R -= nm.get(i);
            }
        }
        if (R <= 0) {
            RES = new int[res.size()];
            Collections.reverse(res);
            for (int i = 0; i < res.size(); i++) {
                RES[i] = res.get(i);
            }

        } else {
            return new int[]{};
        }

        return RES;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str=sc.next().split(",");
        int R = Integer.parseInt(str[0]),N=Integer.parseInt(str[1]);

        int res[] = GetPowerFactor(R, N);
    }


}
