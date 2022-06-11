package com.example.leetcode.leetcode_list200.Com178;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author:cafe3165
 * Date:2020-03-01
 */
public class rank {
    public String rankTeams(String[] votes) {
        //key是参赛团队，value是该团队每个排位获得的票数
        Map<Character, int[]> teamRankMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {

//               排序数组 rankArr 里面存储该字母获得名次i的次数
                int[] rankArr = teamRankMap.getOrDefault(vote.charAt(i), new int[26]);
                rankArr[i]++;
                teamRankMap.put(vote.charAt(i), rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> teamRankList = new ArrayList<>(teamRankMap.entrySet());
//        Collections.sort(teamRankList, (team1, team2) -> {
//            int[] ranks1 = team1.getValue();
//            int[] ranks2 = team2.getValue();
//            //根据投票排序
//            for (int i = 0; i < 26; i++) {
//                if (ranks1[i] != ranks2[i]) {
//                    return ranks2[i] - ranks1[i];
//                }
//            }
//            //字母顺序排序
//            return team1.getKey() - team2.getKey();
//        });
        Collections.sort(teamRankList, new Comparator<Map.Entry<Character, int[]>>() {
            @Override
            public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character, int[]> o2) {
                int[] ranks1 = o1.getValue();
                int[] ranks2 = o2.getValue();
                for (int i = 0; i < 26; i++) {
                    if (ranks1[i] != ranks2[i]) {
                        return ranks2[i] - ranks1[i];
                    }
                }
                return o1.getKey() - o2.getKey();

            }
        });


        //转换为字符串输出
        return teamRankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());

    }

    public static void main(String[] args) {
        rank r = new rank();
        String[] votes = {"WXYZ", "XYZW"};
        r.rankTeams(votes);
    }
}
