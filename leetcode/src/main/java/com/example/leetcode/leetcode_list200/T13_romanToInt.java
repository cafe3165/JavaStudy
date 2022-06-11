package com.example.leetcode.leetcode_list200;

import java.util.HashMap;
import java.util.Map;

public class T13_romanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
       int ans=0,index=0;
       while(index<s.length()-1){
//           index+1<s.length()&&如果最后只剩一个字符的时候，index+2会溢出
           if(index+1<s.length()&&map.containsKey(s.substring(index,index +2))){
               ans+= map.get(s.substring(index,index +2));
               index+=2;
           }else{
               ans+=map.get(s.substring(index, index +1));
                index++;
           }


       }


        return ans;
    }

    public static void main(String[] args) {
        T13_romanToInt t=new T13_romanToInt();
        t.romanToInt("MCMXCI");

    }
}
