package newcoder_jianzhiOffer;

import java.util.Arrays;

public class isContinuousSolution {
    public boolean isContinuous(int[] numbers) {

        if(numbers.length==0)
            return false;
        Arrays.sort(numbers);
        int cnt0 = 0, cntInter = 0;
        for (int n : numbers) {
            if (n == 0)
                cnt0++;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1] && numbers[i] != 0)
                return false;
            if (numbers[i] + 1 == numbers[i + 1])
                continue;
            else if (numbers[i] != 0 && numbers[i + 1] != 0) {
                cntInter += numbers[i + 1] - numbers[i] - 1;
            }
        }
//        System.out.println(cntInter);
//        System.out.println(cnt0);
        if (cnt0 >= cntInter)
            return true;
        else
            return false;


    }

    public static void main(String[] args) {
        int[] numbers = {0, 3, 2, 6, 4};
        isContinuousSolution is = new isContinuousSolution();
        System.out.println(is.isContinuous(numbers));
    }
}
