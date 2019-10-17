package newcoder;

import java.util.ArrayList;
//
public class SolutionJumpFloor {
    public static int JumpFloor(int target) {

        if(target<=1)
            return 1;
        else
            return 2*JumpFloor(target-1);

    }
//


    public static void main(String[] args) {
//        int target = 3;
//        System.out.println(JumpFloor(target));


    }
}
