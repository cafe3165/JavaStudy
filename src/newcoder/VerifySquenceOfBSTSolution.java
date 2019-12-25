package newcoder;

public class VerifySquenceOfBSTSolution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence .length==0){
            return false;
        }

        int root = sequence.length - 1;
        while (root >= 0) {
            int middleMax = 0;
            int count = 0;
//            {3, 4, 9, 5, 12, 11, 10}
            while (sequence[middleMax] < sequence[root]) {
                count++;
                middleMax++;
            }

            while (sequence[middleMax] > sequence[root]) {
                count++;
                middleMax++;
            }

            if (count != root) {
                return false;
            }

            root--;
        }


        return true;


    }

    public static void main(String[] args) {

        VerifySquenceOfBSTSolution v = new VerifySquenceOfBSTSolution();
        int[] sequenc = {3, 4, 9, 5, 12, 11, 10};

        System.out.println(v.VerifySquenceOfBST(sequenc));
    }
}
