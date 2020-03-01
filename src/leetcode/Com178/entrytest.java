package leetcode.Com178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-03-01
 */
public class entrytest {
    public static void main(String[] args) {
        Map<Character, int[]> teamRankMap = new HashMap<>();
        String[] votes = {"WXYZ","XYZW"};

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {

//               排序数组 rankArr 里面存储该字母获得名次i的次数
                int[] rankArr = teamRankMap.getOrDefault(vote.charAt(i), new int[26]);
                rankArr[i]++;
                teamRankMap.put(vote.charAt(i), rankArr);
            }
        }
        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(teamRankMap.entrySet());


    }
}
