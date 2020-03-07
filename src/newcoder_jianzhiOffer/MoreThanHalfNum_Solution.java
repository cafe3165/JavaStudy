package newcoder_jianzhiOffer;

import java.util.Arrays;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int num = 0, t = 0, count = 0;
        Arrays.sort(array);
        t = array[array.length / 2];

        for (int i : array) {
            if(i==t)
                count++;
        }
        if(count>array.length / 2)
            return t;
        return num;

    }

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] array = {0};
        int[] array = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        MoreThanHalfNum_Solution m = new MoreThanHalfNum_Solution();
        m.MoreThanHalfNum_Solution(array);
    }
}
