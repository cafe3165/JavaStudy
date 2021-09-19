package leetcode_list400;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/4 6:34 下午
 */
public class T557reverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ws = s.split(" ");
        for (int i = 0; i < ws.length; i++) {
            sb.append(reverse(ws[i])).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        T557reverseWords t557reverseWords = new T557reverseWords();
        String words = "Let's take LeetCode contest";
        System.out.println( t557reverseWords.reverseWords(words));
    }
}
