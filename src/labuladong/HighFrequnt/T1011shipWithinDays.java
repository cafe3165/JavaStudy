package labuladong.HighFrequnt;

public class T1011shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        int len = weights.length;
        int W[] = new int[len + 1];
        W[0] = 0;
        for (int i = 0; i < len; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
            W[i + 1] = W[i] + weights[i];
        }


        int left = min, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canLoad(mid, W, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    public boolean canLoad(int load, int[] W, int D) {
        int sum = 0;
        int index = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] - W[index] > load) {

                sum++;
                index = i-1;
            }
        }

        return sum < D;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        T1011shipWithinDays t = new T1011shipWithinDays();
        t.shipWithinDays(weights, D);
    }
}
