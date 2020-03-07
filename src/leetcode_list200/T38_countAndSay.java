package leetcode_list200;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-02-19
 */
public class T38_countAndSay {
    public String countAndSay(int n) {
        List<String> countList = new ArrayList<>();
        int count = 0;
        char key = 0;
        countList.add("1");
//        countList.add("11");
//        countList.add("21");
//        countList.add("1211");
        /*  1      1
            2.     11
            3.     21
            4.     1211
            5.     111221*/
        for (int i = 0; i < n; i++) {
            String pre = countList.get(i);
            String cur="";
            for (int j = 0; j < pre.length(); j+=count) {
                count=0;
                for (int k = j; k<pre.length() ; k++) {
                        count++;
                        if(k<pre.length()-1&&pre.charAt(k)!=pre.charAt(k+1)){
                            key=pre.charAt(k);
                            break;
                        }
                    key=pre.charAt(k);

                }
                cur=cur+String.valueOf(count)+String.valueOf(key);

            }
            countList.add(cur);
        }
        return countList.get(n-1);

    }

    public static void main(String[] args) {

        T38_countAndSay t = new T38_countAndSay();

        System.out.println(t.countAndSay(6));

    }
}
