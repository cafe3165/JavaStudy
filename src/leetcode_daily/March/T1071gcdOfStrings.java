package leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-12
 */
public class T1071gcdOfStrings {


    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1 + str2, s2 = str2 + str1;
        if (!s1.equals(s2)) {
            return "";
        }

        int dl = gcd(str1.length(), str2.length());
        return str1.substring(0,dl);

    }

    public int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
//            如果传进来的 a<b在这一步的第一次递归则会倒转过来
            return gcd(b,a%b);
        }


    }


    public static void main(String[] args) {
        T1071gcdOfStrings t = new T1071gcdOfStrings();
        String str1 = "ABCABC", str2 = "ABC";
        t.gcdOfStrings(str1, str2);
    }
}
