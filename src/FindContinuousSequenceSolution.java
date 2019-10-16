import java.util.ArrayList;

public class FindContinuousSequenceSolution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> sumL = new ArrayList<>();
        int p1 = 1, p2 = 2;
        while (p2 > p1) {
            int cur = ((p1 + p2) * (p2 - p1 + 1)) / 2;
            if (cur == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = p1; i <= p2; i++)
                    tmp.add(i);
                sumL.add(tmp);
                p1++;
            }
            if (cur > sum) p1++;
            if (cur < sum) p2++;
        }
//        System.out.println(sumL);


        return sumL;
    }

    public static void main(String[] args) {
        int sum = 100;
        FindContinuousSequenceSolution f = new FindContinuousSequenceSolution();
        f.FindContinuousSequence(sum);
    }
}
