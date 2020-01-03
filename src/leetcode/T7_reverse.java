package leetcode;

public class T7_reverse {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;

        }

        return rev;

    }

    public static void main(String[] args) {
        int x = 345;
//        2147483648 —— —2147483647
//        2147483641

        T7_reverse t = new T7_reverse();

        System.out.println(t.reverse(x));

    }
}
