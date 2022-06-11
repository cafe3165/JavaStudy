package com.example.leetcode.leetcode_list200;
import	java.util.HashMap;
import	java.util.Map;

import java.util.HashSet;
import java.util.Set;

public class T3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < len && j < len) {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;


    }
    public int lengthOfLongestSubstring2(String s) {
        int len=s.length(),ans=0;
        Map<Character, Integer> map = new HashMap<> ();
        for(int i=0,j=0;j<len;j++){

            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j)),i);
            }
            ans=Math.max(ans, j-i+1);
            map.put(s.charAt(j),j+1);


        }
        return ans;



    }



    public static void main(String[] args) {
        T3_lengthOfLongestSubstring t = new T3_lengthOfLongestSubstring();
        t.lengthOfLongestSubstring2("pwwkew");
    }


}
