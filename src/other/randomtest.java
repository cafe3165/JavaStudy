package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class randomtest {
    public static void main(String[] args) {
        int n = 3;
        List<Integer> r = new Random().ints(0, n).distinct().limit(n).boxed().collect(Collectors.toList());
        System.out.println(Arrays.toString(r.toArray()));
        int find = 4;
        List<Integer> res = new ArrayList<>();
        int bit=n<<1;
        for (int i = 0; bit!=0; i++) {
             bit = bit >> 1;
            List<Integer> zero = new ArrayList<>();
            List<Integer> one = new ArrayList<>();
            for (int j = 0; j < r.size(); j++) {
                if ((r.get(j) & bit) == 0) {
                    zero.add(r.get(j));
                } else {
                    one.add(r.get(j));
                }
            }
            if ((find & bit) == 0) {
                r = zero;
            } else {
                r = one;
            }
        }
        if(r.size()==0){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }


    }
}
