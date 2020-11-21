package leetcode_M;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T204countPrimes {
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }

        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 2;
        countPrimes(n);
    }
}
