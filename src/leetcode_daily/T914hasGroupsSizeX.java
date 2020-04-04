package leetcode_daily;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-03-27
 */
public class T914hasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            List<Integer> tmp = map.getOrDefault(deck[i], new ArrayList<>());
            tmp.add(deck[i]);
            map.put(deck[i], tmp);
        }
//        int min = map.get(deck[0]).size();
//        for (Integer i : map.keySet()) {
//            if(min>map.get(i).size()){
//                min=map.get(i).size();
//            }
////            if (min != map.get(i).size()||map.get(i).size()<2) {
////                return false;
////            }
//        }

//        for(Integer i:map.keySet()){
//            int l=map.get(i).size();
//            if(l!=min){
//                if(gcd(l,min)<2){
//                    return false;
//                }
//            }
//            if(l<2){
//                return false;
//            }
//        }
        int[] ll=new int[map.size()];
        int index=0;
        for(Integer i:map.keySet()){
            ll[index++]=map.get(i).size();
        }

        for (int i = 0; i < ll.length; i++) {
            if(ll[i]<2){
                return false;
            }
            for (int j = i+1; j < ll.length; j++) {
                if(gcd(ll[i],ll[j])<2){
                    return false;
                }
            }
        }


        return true;

    }
    public static int gcd(int x,int y)
    {
        return y!=0?gcd(y,x%y):x;
    }
    public static void main(String[] args) {
        T914hasGroupsSizeX t = new T914hasGroupsSizeX();
        int[] deck = {1};
        t.hasGroupsSizeX(deck);
//        int x=gcd(4,6);
    }
}
