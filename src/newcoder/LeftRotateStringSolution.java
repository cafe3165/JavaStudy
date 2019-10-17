package newcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeftRotateStringSolution {
    public String LeftRotateString(String str, int n) {
        String res="";
        char[] chars=str.toCharArray();
        List<Character> CL=new ArrayList<>();
        for (char c :
                chars) {
            CL.add(c);
        }
        Collections.rotate(CL,-n);
//        System.out.println(CL);
        for (char c :
                CL) {
            res += c;
        }
//        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {
        LeftRotateStringSolution l = new LeftRotateStringSolution();
        String S = "abcXYZdef";
        int n = 4;
        l.LeftRotateString(S, n);
    }
}
