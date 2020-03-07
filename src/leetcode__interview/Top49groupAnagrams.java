package leetcode__interview;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-03-05
 */
public class Top49groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,Integer[]> map=new HashMap<>();
        Set<String> set = new HashSet<>();
//        List<List<String>> res = new ArrayList<>();
        List<String> chars = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String str;
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            if (!set.contains(String.valueOf(chs))) {
                set.add(String.valueOf(chs));
            }
            chars.add(String.valueOf(chs));
        }
        List<List<String>> res = new ArrayList<>();
        List<List<Integer>> resIndex = new ArrayList<>();
        for (String s :
                set) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < chars.size(); i++) {
                if (s.equals(chars.get(i))) {
                    tmp.add(i);
                }
            }
            resIndex.add(tmp);
        }

        for (List<Integer> il :
                resIndex) {
            List<String> tmp = new ArrayList<>();
            for (Integer i :
                    il) {
                tmp.add(strs[i]);
            }
            res.add(tmp);

        }


        System.out.println();

        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str:
             strs) {
            char[] chs=str.toCharArray();
            Arrays.sort(chs);
            String Key=String.valueOf(chs);
            if(!map.containsKey(Key)){
                map.put(Key,new ArrayList<>());
            }
            map.get(Key).add(str);

        }
        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        Top49groupAnagrams t = new Top49groupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        t.groupAnagrams2(strs);

    }

}
