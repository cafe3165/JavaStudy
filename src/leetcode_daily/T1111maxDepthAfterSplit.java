package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-04-01
 */
public class T1111maxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int [seq.length()];
        int idx = 0;
        for(char c: seq.toCharArray()) {
            System.out.println((idx & 1)+" "+((idx + 1) & 1));
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;



    }

    public static void main(String[] args) {
        String seq = "()(())()";
        T1111maxDepthAfterSplit t = new T1111maxDepthAfterSplit();
        t.maxDepthAfterSplit(seq);


    }
}
