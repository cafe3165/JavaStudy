package newcoder;

import java.util.ArrayList;

public class maxInWindowsSolution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> maxNums = new ArrayList<>();
        if(size==0){
            return maxNums;
        }
// {[2,3,4],2,6,2,5,1}
        int head = 0, tail = head + size-1;
        while (tail < num.length) {
            int maxI = findMaxIndex(num, head, tail);
            maxNums.add(num[maxI]);
            head++;
            tail = head + size-1;

        }

//        System.out.println(maxNums);
        return maxNums;

    }


    public int findMaxIndex(int[] num, int head, int tail) {
        int maxIndex = 0;
        int Max=Integer.MIN_VALUE;
        for (int i = head; i <=tail ; i++) {
            if(Max<num[i])
            {
                Max=num[i];
                maxIndex=i;
            }

        }


        return maxIndex;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;

        maxInWindowsSolution m = new maxInWindowsSolution();
        m.maxInWindows(num, size);

    }
}
