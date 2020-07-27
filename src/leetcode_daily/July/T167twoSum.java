package leetcode_daily.July;

public class T167twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int cur = numbers[l] + numbers[r];
            if (cur == target) {
                break;
            }
            if (cur > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args) {
        T167twoSum t = new T167twoSum();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        t.twoSum(numbers, target);

    }
}
