package newcoder_jianzhiOffer;

public class InversePairsSolution {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;

    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                copy[k] = array[i];
                i++;
                k++;
            } else {
                copy[k] = array[j];
                j++;
                k++;
                count += mid - i + 1;
                if (count >= 1000000007)//数值过大求余
                    count %= 1000000007;
            }
        }
        while (i <= mid) {
            copy[k] = array[i];
            k++;
            i++;
        }//复制排序后左边子序列剩余

        while (j <= high) {
            copy[k] = array[j];
            k++;
            j++;
        }//复制排序后右边子序列剩余
        for (i = low; i <= high; i++)
            array[i] = copy[i];//更新a数组
        return (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
        InversePairsSolution inverse = new InversePairsSolution();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};

        System.out.println(inverse.InversePairs(array));
    }
}
