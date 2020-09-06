package NewReal;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-09-06
 */
public class Tencent_2 {
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        used = new boolean[n];
        List<List<Integer>> groupsList = new ArrayList<>();
        int index0 = -1;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            List<Integer> gruop = new ArrayList<>(x);
            for (int j = 0; j < x; j++) {
                int num = sc.nextInt();
                if (num == 0) {
                    index0 = i;
                }
                gruop.add(num);
            }
            groupsList.add(gruop);
        }
        int res = solve(groupsList, index0);
        System.out.println(res);

    }
    // index0为记录“0”所在组的下标
    public static int solve(List<List<Integer>> groupsList, int index0) {
        int count = 1;
        List<Integer> startList = groupsList.get(index0);
        used[index0] = true;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < startList.size(); i++) {
            set.add(startList.get(i));
        }
        while (count < groupsList.size()) {
            Integer[] s = set.toArray(new Integer[0]);
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < groupsList.size(); j++) {
                    if (used[j]) {
                        continue;
                    } else {
                        if (groupsList.get(j).contains(s[i])) {
                            set.addAll(groupsList.get(j));
                            used[j] = true;
                        }
                    }
                }
            }
            count++;
        }
        return set.size();
    }
}
