package leetcode_list200;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-06-04
 */
public class T40combinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        //先排序，便于剪枝
        Arrays.sort(candidates);
        backTrack(res, path, candidates, 0, candidates.length, target);
        LinkedHashSet<List<Integer>> set=new LinkedHashSet<>(res);
        res=new ArrayList<>(set);



        return res;
    }

    private static void backTrack(List<List<Integer>> res, Deque<Integer> path, int[] candidates,
                                  int begin, int len, int resNum) {
        if (resNum == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = begin; i < len; i++) {
            //剪枝
            if (resNum - candidates[i] < 0) {
                break;
            }
            //除去重复的情况
//            if(i>begin&&candidates[i]==candidates[i-1]){
//                continue;
//            }

            path.addLast(candidates[i]);
            backTrack(res, path, candidates, i + 1, len, resNum - candidates[i]);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(candidates, target);
    }
}
