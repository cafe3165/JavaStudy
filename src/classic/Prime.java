package classic;

/**
 * Author:cafe3165
 * Date:2020-03-30
 */
public class Prime {
    public static boolean[] eratos_prime(int n)// 埃拉托色尼 素数筛选法
    {
        boolean[] ans = new boolean [n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = true;
        }
        ans[0] = ans[1] = false;
        for (int i = 2; i <= n; i++) {

            if (ans[i]) {
                int j = i + i;
                while (j <= n) {
                    ans[j] = false;
                    j += i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( eratos_prime(5));
    }

}
