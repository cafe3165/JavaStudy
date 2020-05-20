package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-05-19
 */
public class yuewen3 {
    public static char findFirstNonRepeatChar(String str) throws Exception {
        char[] chs = str.toCharArray();
        Map<Character, Integer> map=new LinkedHashMap<>();
        for (char c:chs) {
            int count=map.getOrDefault(c,0);
            map.put(c,count+1);
        }
        // write code here
        for(Character c:map.keySet()){
            if(map.get(c)==1){
                return c;
            }
        }
        return (char)(1/0);
    }

    public static void main(String[] args) throws Exception {
        String str = "hellohehe";
        char c = findFirstNonRepeatChar(str);
        System.out.println(c);

    }
}
