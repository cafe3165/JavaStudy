package leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-19
 */
public class T409longestPalindrome_easy {
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A'] += 1;
        }

        int ans = 0;

        for (int x : cnt) {

            ans += (x / 2) * 2;
            if (x % 2 == 1 && ans % 2 ==  0){
                ans++;
            }




        }
        return ans;


    }

    public static void main(String[] args) {
        String s = "aaaAaaaa";
        T409longestPalindrome_easy t = new T409longestPalindrome_easy();
        t.longestPalindrome(s);


    }
}
