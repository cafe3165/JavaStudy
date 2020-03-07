package leetcode_list200;

public class T1_twoSum {
    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
                    return new int[]{i,j};
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution");

    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 0;
        T1_twoSum t = new T1_twoSum();
        int[] r=t.twoSum(nums, target);
        System.out.println(r[0]+" "+r[1]);
    }
}
