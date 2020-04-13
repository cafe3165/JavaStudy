package Real;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-12
 */
public class kuaishou4 {
    /**
     * 获取最大可同事办公员工数
     *
     * @param pos char字符型二维数组 工位分布
     * @return int整型
     */
    public static class liantong {
        int i;
        int j;
        int no;

        public liantong(int i, int j, int no) {
            this.i = i;
            this.j = j;
            this.no = no;
        }
    }


    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int GetMaxStaffs(char[][] pos) {
        if(pos.length==0){
            return 0;
        }
        int res = 0;
        char[][] origin= Arrays.copyOfRange(pos,0,pos.length);

        // write code here
        boolean[][] vis = new boolean[pos.length][pos[0].length];
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (pos[i][j] == '.') {

                    res+= dfs(i, j, pos, vis);
//                    for (int k = 0; k <pos.length ; k++) {
//
//                    }
                }
            }
        }

        return res;
    }

    public static int dfs(int i, int j, char[][] pos, boolean[][] vis) {

        if (i > pos.length - 1 || i < 0 || j > pos[0].length - 1 || j < 0 || vis[i][j] || pos[i][j] == '*') {
            return 0;
        }
//        if(i>=0&&i<pos.length&&j>=0&&j<pos[0].length&&)



        vis[i][j] = true;
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int newx = i + dir[k][0];
            int newy = j + dir[k][1];
//            if (pos[newx][newy] == '.') {
            max += dfs(newx, newy, pos, vis);
//            }
        }

        return max + 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//[[*,.,*,*,.],[*,.,*,*,*],[*,.,*,*,.]]
        char[][] pos = {
                {'*', '.', '*', '*', '.'},
                {'*', '.', '*', '*', '*'},
                {'*', '.', '*', '*', '.'}
        };

        GetMaxStaffs(pos);
    }

}
