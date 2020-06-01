package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-01
 */
public class T66plusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int tmp = digits[i];
            if (i == len - 1) {
                tmp++;
                digits[i] = tmp % 10;
                carry=tmp/10;
                continue;
            }
            digits[i] = (tmp + carry) % 10;
            carry = (tmp + carry) / 10;
        }
        if (carry > 0) {
            int[] res = new int[len + 1];
            System.arraycopy(digits, 0, res, 1, len);
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {4,3,2,1};
        plusOne(digits);

    }
}
