package com.example.leetcode.leetcode_list200;

public class T11_maxArea {
    public int maxArea(int[] height) {
        if(height.length==2){
            return Math.min(height[0],height[1]);
        }

        int low = 0, high = height.length - 1;
        int max = 0;
        while (low < high) {
            int curHeigh = Math.min(height[low], height[high]);
            max = Math.max(max, (high - low) * curHeigh);

            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }


        }
        return max;


    }

    public static void main(String[] args) {
        int[] height = {
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };
        T11_maxArea t = new T11_maxArea();

        System.out.println(t.maxArea(height));
    }
}
