package NewReal;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author:cafe3165
 * Date:2020-09-17
 */
public class JD_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
//        List<String> res = new LinkedList<>();
//        for (int i = 0, j = 1; i < text.length() && j < text.length(); j++) {
//            if (text.charAt(j) <'0'||text.charAt(j)>'9'||j==text.length()-1) {
//                if(j==text.length()-1){
//                    j++;
//                }
//                String cur = text.substring(i, j);
//                if(j==text.length()&&cur.length()>4){
//                    cur=cur.substring(0,4);
//                }
//                if (cur.length() == 4 && isYear(cur)) {
//                    res.add(cur);
//                }
//                i = j + 1;
//            }
//        }
//        for (int i = 0; i < res.size(); i++) {
//            if (i < res.size() - 1) {
//                System.out.print(res.get(i) + " ");
//            } else {
//                System.out.print(res.get(i));
//            }
//        }
//

        solve(text);

    }

    public static void solve(String s) {
        String regx = "\\D1\\d\\d\\d\\D|\\D2\\d\\d\\d\\D|\\D3\\d\\d\\d\\D"
                + "|"
                + "1\\d\\d\\d\\D|2\\d\\d\\d\\D|3\\d\\d\\d\\D"
                + "|"
                + "\\D1\\d\\d\\d$|\\D2\\d\\d\\d$|\\D3\\d\\d\\d$";


        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(s);
        List<String> res = new LinkedList<>();
        while (matcher.find()) {
            String year = matcher.group();
            if (year.length() == 6) {
                res.add(year.substring(1, year.length() - 1));
            } else {
                if (year.charAt(0) < '0' || year.charAt(0) > '9') {
                    res.add(year.substring(1));
                } else {
                    res.add(year.substring(0, year.length() - 1));
                }
            }

        }
        for (int i = 0; i < res.size(); i++) {
            if (i < res.size() - 1) {
                System.out.print(res.get(i) + " ");
            } else {
                System.out.print(res.get(i));
            }
        }
    }


    public static boolean isYear(String s) {
        if (s.length() < 1) {
            return false;
        }
        //数字
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        int x = 1000;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += ((s.charAt(i) - '0') * x);
            x /= 10;
        }
        if (sum < 1000 || sum > 3999) {
            return false;
        }
        return true;
    }
}
