package leetcode_list400;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/6/20 7:54 下午
 */
public class T412fizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (canDivideByThree(i) && canDividenByFive(i)) {
                res.add("FizzBuzz");
            } else if (canDivideByThree(i)) {
                res.add("Fizz");
            } else if (canDividenByFive(i)) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    private static boolean canDivideByThree(int var) {
        if (var % 3 == 0) {
            return true;
        }
        return false;
    }

    private static boolean canDividenByFive(int var) {
        if (var % 5 == 0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        List<String> res = fizzBuzz(15);
        System.out.println(res.toString());
    }

}
