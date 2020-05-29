package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-04-01
 */
public class T1111maxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
//        int[] ans = new int[seq.length()];
//        int idx = 0;
//        for (char c : seq.toCharArray()) {
//            System.out.println(idx & 1);
//            if (c == '(') {
//
//                ans[idx++] = idx&1;
//            } else {
//                ans[idx++] = ((idx + 1) & 1);
//            }
//        }
//        return ans;
        int d = 0;
        int[] ans=new int[seq.length()];
        int index=0;
        for (char  c : seq.toCharArray()) {
            if (c == '(') {
                ++d;
                ans[index]=(d % 2);
                index++;
            } else {
                ans[index]=(d % 2);
                index++;
                --d;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String seq = "()((()))()";
        T1111maxDepthAfterSplit t = new T1111maxDepthAfterSplit();
        t.maxDepthAfterSplit(seq);

//        int[] a=new int[5];
//        int i=0;
//        a[i++]=i&1;
//        System.out.println();
    }
}
