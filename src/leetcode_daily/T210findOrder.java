package leetcode_daily;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2020-05-17
 */
public class T210findOrder {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        // 邻接表
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        int[] inDegree = new int[numCourses];
        //初始化邻接表和入度数组
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        //记录入度为0的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0;

        while (!q.isEmpty()) {
            int head = q.poll();
            res[count++] = head;

            Set<Integer> successors = adj[head];
            for (int next : successors) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (count == numCourses) {
            return res;
        }


        return new int[0];


    }

    public static void main(String[] args) {
        int num = 4;
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        findOrder(num, pre);

    }
}
