package newcoder_jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class NumberOf1Solution {
    public static int NumberOf1(int n) {
        List<Integer> NumberList = new ArrayList<Integer>();
        int count = 0;
        boolean symbol = false;
        if (n < 0)
            symbol = true;
        n = Math.abs(n);
        while (n != 0) {
            int m = n % 2;
            NumberList.add(m);
            n /= 2;

        }
        if(symbol){
            for (int i = 0; i < NumberList.size()-1; i++) {
                NumberList.set(i,NumberList.get(i)^1);
            }
            NumberList.add(1);
        }



        for (Integer i : NumberList) {
            if (i == 1) {
                count++;
            }
        }

        return count;


    }

    public static void main(String[] args) {
        int target = -5;
        System.out.println(NumberOf1(target));
    }

}
