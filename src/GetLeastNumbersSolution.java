import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbersSolution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if(k>input.length || k==0)
            return res;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int in : input) {
            if (pq.size() != k)
                pq.add(in);
            else if (in < pq.peek()) {
                pq.poll();
                pq.add(in);
            } else
                continue;
        }
        for (int result : pq)
            res.add(result);

//        System.out.println(res);

        return res;

    }

    public static void main(String[] args) {
        GetLeastNumbersSolution glsn = new GetLeastNumbersSolution();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        glsn.GetLeastNumbers_Solution(input, k);
    }
}
