package Real;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bytedance_inter1 {
    public static void main(String[] args) {
        int[] a = {10, 20, 10};
        int[] b = {5, 7, 2};
        int[] B = new int[b.length + 1];

        B[0] = 0;
        //构造前缀和数组
        for (int i = 1; i < B.length; i++) {
            B[i] = B[i - 1] + b[i - 1];
        }
        Arrays.sort(a);
        int index = 0;
        List<Integer> res = new ArrayList<>();
        int tmp = 0;
        for (int i = 1; i < B.length; i++) {
            //如果苹果数量够摘
            if (a[index] >= B[i]) {
                tmp = (a.length - index) * (B[i] - B[i - 1]);

            } else {
                tmp = 0;
                //把苹果树不够的树摘完
                while (a[index] < B[i]) {
                    tmp += a[index] - B[i - 1];
                    index++;
                }
                //摘苹果数够的树，摘取 B[i]-B[i-1]=b[i]个
                tmp += (a.length - index) * (B[i] - B[i - 1]);
            }
            res.add(tmp);
        }
    }
}
