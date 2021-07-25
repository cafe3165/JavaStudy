package leetcode_list400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/25 7:11 下午
 */
public class T207canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> relation = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            relation.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
            relation.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : relation.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.offer(cur);
                }
            }
        }

        return numCourses == 0;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {4, 2}, {5, 3}, {5, 4}};
        T207canFinish t = new T207canFinish();
        System.out.println(t.canFinish(numCourses, prerequisites));

    }
}
