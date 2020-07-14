package classic;


public class shortest_distance {

    //初始化一个随机数组
    public static int[] initializationArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (int) (Math.random() * 100);
        }//采用随机函数随机生成1~100之间的数
        return result;

    }

    //返回数组中最大值
    public static int getArrayMax(int a[], int first, int end) {
        int max = a[first];
        for (int i = first; i < end; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    //返回数组中最小值
    public static int getArrayMin(int a[], int first, int end) {
        int min = a[first];
        for (int i = first; i < end; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    //交换数组a[n]中两个数的值
    public static void swapArray(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //采用分治法将数组a[n]分成两组,满足a[n1]<m,a[n2]>m(其中n1+n2 = n)
    public static int divideArray(int a[], int first, int end) {
        int max = getArrayMax(a, first, end);
        int min = getArrayMin(a, first, end);
        double m = (max + min) / 2.0;
        //System.out.println("分治法算出中位数m:"+m);
        int i = first, j = end - 1;
        //int a1 = 0;
        for (; i + 1 <= j; ) {
            while (a[i] < m && i + 1 <= j) {
                i++;
            }
            while (a[j] > m && i + 1 <= j) {
                j--;
            }
            //  a1++;
            //    System.out.println("第"+a1+"此交换时a[i] = "+a[i]+" i = "+i+"  a[j] = "+a[j]+" j = "+j);
            swapArray(a, i, j);   //a[i]大于m的值与a[j]小于m的值进行交换，但数组的位置不变
        }
        //System.out.println("分组后，返回的序号j值是："+(j));
        return j;
    }

    //采用递归法合并最短距离值，返回最短距离的点
    public static int[] getMinDistancePoint(int a[], int result[], int n, int first, int end) {

        if (end - first <= 1) {   //递归终止条件
            return result;
        }

        int j = divideArray(a, first, end);
        int minDistance = result[1] - result[0];  //最短距离两点之间的距离大小
        if (minDistance > getArrayMin(a, j, end) - getArrayMax(a, first, j)) {
            result[0] = getArrayMax(a, first, j);   //最短距离两点中数值最小的点
            result[1] = getArrayMin(a, j, end);   //最短距离两点中数值最小的点
        }
        int result_one[] = getMinDistancePoint(a, result, 2, first, j);   //递归
        int minDistance_one = result_one[1] - result_one[0];
        int result_two[] = getMinDistancePoint(a, result, 2, j, end);   //递归
        int minDistance_two = result_two[1] - result_two[0];
        if (minDistance > minDistance_one)
            result = result_one;
        if (minDistance > minDistance_two)
            result = result_two;
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int b[] = new int[2];
        b[0] = 0;
        b[1] = 100;
        a = initializationArray(10);
        String one_text = "";
        for (int i = 0; i < 10; i++) {
            one_text += "直线随机点Point[" + i + "] = " + a[i] + "\n";
            //System.out.print("数组a["+i+"] = "+a[i]+"\n");
        }
        int result[] = getMinDistancePoint(a, b, 2, 0, 10);
        //System.out.println("result[0] = "+result[0]+"\n"+"result[1] = "+result[1]);
        one_text += "最短距离点对第1点result[0] = " + result[0] + "\n" + "最短距离点对第2点result[1] = " + result[1];
        System.out.print(one_text);
    }
}
