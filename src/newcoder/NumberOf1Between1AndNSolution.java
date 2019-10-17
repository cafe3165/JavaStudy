package newcoder;

public class NumberOf1Between1AndNSolution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;

        char[][] CharNumber = new char[n + 1][];
        for (int i = 1; i <= n; i++)
            CharNumber[i] = String.valueOf(i).toCharArray();
        for (int i = 1; i < n + 1; i++) {
            for (char c : CharNumber[i]) {
                if (c == '1')
                    count++;
            }
        }
        return count;

    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        boolean f = true;
        int mod = 10;
        while (f) {
            int low = n % mod;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 13;
        NumberOf1Between1AndNSolution N = new NumberOf1Between1AndNSolution();
        N.NumberOf1Between1AndN_Solution(n);
    }
}
