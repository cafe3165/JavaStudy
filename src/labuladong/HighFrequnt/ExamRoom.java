package labuladong.HighFrequnt;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-08-01
 */
public class ExamRoom {

    private TreeSet<int[]> pq;
    private Map<Integer, int[]> start;
    private Map<Integer, int[]> end;
    private int N;


    public ExamRoom(int N) {
        pq = new TreeSet<>((o1, o2) -> {
            int dis1 = distance(o1[0], o1[1]);
            int dis2 = distance(o2[0], o2[1]);
            if (dis1 == dis2) {
                return o1[0] - o2[0];
            }
            return dis1 - dis2;
        });
        start = new HashMap<>();
        end = new HashMap<>();
        addInter(new int[]{-1, N});
        this.N = N;
    }

    private int distance(int x, int y) {
        if (x == -1) {
            return y;
        }
        if (y == N) {
            return N - x - 1;
        }
        return (x + y) / 2;
    }

    public int seat() {
        int[] longest = pq.last();
        int seat ;
        if (longest[0] == -1) {
            seat = 0;
        } else if (longest[1] == N) {
            seat = N - 1;
        } else {
            seat = longest[0] + (longest[1] - longest[0]) / 2;
        }
        int[] left = new int[]{longest[0], seat};
        int[] right = new int[]{seat, longest[1]};
        remInter(longest);
        addInter(left);
        addInter(right);
        return seat;
    }

    public void leave(int p) {
        int[] left = end.get(p);
        int[] right = start.get(p);
        int[] merge = new int[]{left[0], right[1]};
        remInter(left);
        remInter(right);
        addInter(merge);
    }

    private void addInter(int[] inter) {
        pq.add(inter);
        start.put(inter[0], inter);
        end.put(inter[1], inter);
    }

    private void remInter(int[] inter) {
        pq.remove(inter);
        start.remove(inter[0]);
        end.remove(inter[1]);
    }

    public static void main(String[] args) {
        ExamRoom e = new ExamRoom(10);
        System.out.println(e.seat());
        System.out.println(e.seat());
        System.out.println(e.seat());
        System.out.println(e.seat());
        e.leave(4);
        System.out.println(e.seat());
    }
}
