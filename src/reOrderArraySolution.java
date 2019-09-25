public class reOrderArraySolution {
    public static void reOrderArray(int[] array) {
        int[] odd = new int[1000];
        int[] even = new int[1000];
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i : array) {
            if (i % 2 == 1)
                odd[index1++] = i;
            else
                even[index2++] = i;
        }
//        int[] merge = new int[index1+index2];
        for (int i = 0; i < index1; i++) {
            array[index3++] = odd[i];
        }
        for (int i = 0; i < index2; i++) {
            array[index3++] = even[i];
        }

//        System.out.println();
//        for (int i = 0; i < merge.length; i++) {
//            System.out.println(merge[i]);
//        }

    }

    public static void main(String[] args) {
//        int target=5;
        int[] array = {1, 4, 6, 5, 3};
        reOrderArray(array);
    }
}
