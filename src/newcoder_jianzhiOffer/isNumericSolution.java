package newcoder_jianzhiOffer;

import java.util.regex.Pattern;

public class isNumericSolution {
    public boolean isNumeric(char[] str) {

        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern, s);
    }


    public static void main(String[] args) {
        isNumericSolution is = new isNumericSolution();
        char[] str = {'+', '1', '0', '0'};
        char[] str2 = {'5', 'e', '2', '0'};
        char[] str3 = {'-', '.', '1', '4'};
        System.out.println(is.isNumeric(str2));
    }

}
