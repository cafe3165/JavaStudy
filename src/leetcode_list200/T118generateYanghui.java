package leetcode_list200;

import J2SE.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-22
 */
public class T118generateYanghui {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0){
            return res;
        }
        res.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows==1){
            return res;
        }
        res.add(new ArrayList<>(Arrays.asList(1, 1)));
        if(numRows==2){
            return res;
        }

        for (int i = 3; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>(i);
            List<Integer> pre = res.get(i - 2);
            tmp.add(1);
            int pi = 0;
            for (int j = 1; j < i && pi+1 < pre.size(); j++) {
                tmp.add(pre.get(pi) + pre.get(pi + 1));
                pi++;
            }
            tmp.add(1);
            res.add(tmp);
        }


        return res;
    }

    public static void main(String[] args) {
        int numRows = 5;
        T118generateYanghui t = new T118generateYanghui();
        t.generate(numRows);

    }
}
