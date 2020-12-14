package leetcode_list400;

public class T941validMountainArray {
    public static boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if (len == 1 || len == 2) {
            return false;
        }
        int left = 0, right = len - 1;
        while (left < len - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        return left > 0 && right < len - 1 && left == right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        validMountainArray(arr);
    }
}
