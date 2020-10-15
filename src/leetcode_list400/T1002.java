package leetcode_list400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-10-14
 */
public class T1002 {
    public static List<String> commonChars(String[] A) {
        int len = A.length;
        List<String> res = new ArrayList<>();
        List<HashMap<Character, Integer>> mapList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            String str = A[i];
            for (int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            }
            mapList.add(map);
        }
        for (int i = 0; i < 26; i++) {
            Character c = Character.valueOf((char)(i+'a'));
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < mapList.size(); j++) {
                if(mapList.get(j).containsKey(c)){
                    count = Math.min(count,mapList.get(j).get(c));
                }else{
                    count = 0;
                    break;
                }
            }

            for (int j = 0; j < count; j++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
        List<String> res = commonChars(A);
        System.out.println(res);
    }
}
