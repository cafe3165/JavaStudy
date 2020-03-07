package leetcode_list200;

public class T9_isPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
//        我们将原始数字除以 10，然后给反转后的数字乘上 10，
//        所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
        int ans = 0;
        while (ans < x) {
            ans = ans * 10 + x % 10;
            x/=10;
        }
        return (x==ans)||(x==ans/10);


    }

    public static void main(String[] args) {
        T9_isPalindrome t = new T9_isPalindrome();

        System.out.println(t.isPalindrome(12321));
    }
}
