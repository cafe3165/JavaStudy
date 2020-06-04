package leetcode_daily.March;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2020-03-29
 */
public class T1162maxDistance {
    class land {
        public int x;
        public int y;
        public land(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<land> q = new LinkedList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    q.offer(new land(i,j));
                }

            }
        }
        int res = 0;
        if(q.size()==0||q.size()==row*col){
            return -1;
        }
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                land tmp=q.poll();
                for (int[] d :dir) {
                    int X=tmp.x+d[0];
                    int Y=tmp.y+d[1];
                    if(X>=0&&X<row&&Y>=0&&Y<col&&grid[X][Y]==0){
                        q.offer(new land(X,Y));
//                        这片海访问过了
                        grid[X][Y]=-1;
                    }
                }

            }
            res++;
        }

        return res-1;
    }

    public static void main(String[] args) {
        T1162maxDistance t = new T1162maxDistance();
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        t.maxDistance(grid);
        String sb=new StringBuffer("tostring").reverse().toString();
        System.out.println(sb);

    }
}
