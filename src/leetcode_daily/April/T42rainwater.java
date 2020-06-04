package leetcode_daily.April;

/**
 * Author:cafe3165
 * Date:2020-04-04
 */
public class T42rainwater {
    public int trap(int[] height) {
        int res = 0;
//        for (int i = 1; i < height.length; i++) {
//            int rightmax = 0;
//            for (int j = i + 1; j < height.length; j++) {
//                if (height[j] > rightmax) {
//                    rightmax = height[j];
//                }
//            }
//            int leftmax = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                if (height[j] > leftmax) {
//                    leftmax = height[j];
//                }
//            }
//            int min = Math.min(rightmax, leftmax);
//
//            res =min>height[i]? res+min - height[i]:res;
//
//        }
        int[] lm = new int[height.length], rm = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            lm[i] = Math.max(lm[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rm[i] = Math.max(rm[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(rm[i], lm[i]);
            res = min > height[i] ? res + min - height[i] : res;

        }


        return res;

    }


//    public int trap2(int[] height) {
//        ArrayList<Integer> l = new ArrayList<>();
//        Arrays.binarySearch();
//    }

    public static void main(String[] args) {

        T42rainwater t = new T42rainwater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        t.trap(height);
    }

}
