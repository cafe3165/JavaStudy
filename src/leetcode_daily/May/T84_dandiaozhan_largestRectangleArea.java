package leetcode_daily.May;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public class T84_dandiaozhan_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);

            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        T84_dandiaozhan_largestRectangleArea t = new T84_dandiaozhan_largestRectangleArea();
        t.largestRectangleArea(height);
    }
}
