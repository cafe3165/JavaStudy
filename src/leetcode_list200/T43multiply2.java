package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T43multiply2 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num2.length() - i - 1; j++) {
                sb.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
//                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int n1 = num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                sb.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            res = add(res, sb.reverse().toString());
        }
        return res;
    }

    public static String add(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        System.out.println( multiply(num1,num2));


    }
}
