package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Competition_3 {
    ////    public static int[] fraction(int[] cont) {
////        int len = cont.length;
////        int mo = 0;
////        int de = 0;
////        int index = len - 1;
////        de = cont[index];
////        mo = 1;
////        for (int i = 0; i < len - 1; i++) {
////            mo = cont[index - 1] * de + mo;
////
////            int tmp = mo;
////            mo = de;
////            de = tmp;
////            index--;
////        }
////        System.out.println(mo);
////        System.out.println(de);
////        int[] c = {de, mo};
////        return c;
////    }
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        Map<Integer, List<Integer>> Obst = new HashMap<Integer, List<Integer>>();
        for (int[] obstacle : obstacles) {
            int ObsX = obstacle[0], ObsY = obstacle[1];
            List<Integer> ListY = Obst.getOrDefault(ObsX, new ArrayList<Integer>());
            if (!ListY.contains(ObsY)) {
                ListY.add(ObsY);
                Obst.put(ObsX, ListY);
            }
        }
        int Curx = 0, Cury = 0;
        char[] com = command.toCharArray();
        int comLen = com.length;
        int comIndex = 0;
        while (Curx <= x && Cury <= y) {

            char c = com[comIndex++];
            if (comIndex >= comLen)
                comIndex %= comLen;
            if (c == 'U')
                Cury++;
             else
                Curx++;

            if (Curx == x && Cury == y)
                return true;

            List<Integer> ListY = Obst.getOrDefault(Curx, new ArrayList<Integer>());
            if (ListY.contains(Cury))
                return false;



        }
        return false;


    }


    public static void main(String[] args) {
        String command = "URR";
//        int[][] obstacles = {{2, 2}};
        int[][] obstacles = {{4, 2}};

        int x = 3, y = 2;
        System.out.println(robot(command, obstacles, x, y));
    }
}
