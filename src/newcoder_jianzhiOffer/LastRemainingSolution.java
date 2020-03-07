package newcoder_jianzhiOffer;

import java.util.LinkedList;

public class LastRemainingSolution {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            list.add(i);
        int tmp = 0;
        while (list.size() > 1) {
            tmp = (tmp + m - 1) % list.size();
            list.remove(tmp);
        }

        return list.size() == 1 ? list.get(0) : -1;

    }

    public static void main(String[] args) {
        LastRemainingSolution l = new LastRemainingSolution();
        int n = 5, m = 3;
        l.LastRemaining_Solution(n, m);
    }
}