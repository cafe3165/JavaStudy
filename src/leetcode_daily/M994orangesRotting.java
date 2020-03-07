package leetcode_daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2020-03-04
 */
public class M994orangesRotting {
    class Pos {
        int x, y, min;

        public Pos(int _x, int _y, int _min) {
            x = _x;
            y = _y;
            min = _min;
        }
    }

    static int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Queue<Pos> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int minute = 0;

//        将腐烂的句子加入到队列中去
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pos(i, j, minute));
                }
            }
        }

//        开始腐烂
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            minute = pos.min;
            for (int i = 0; i < 4; i++) {
                int X = pos.x + direct[i][0];
                int Y = pos.y + direct[i][1];
                if(X>=0&&X<row&&Y>=0&&Y<col&&grid[X][Y]==1){
                    grid[X][Y]=2;
                    queue.add(new Pos(X,Y,minute+1));
                }
            }


        }

//        检查还有没有新鲜的
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }


        return minute;
    }

    public static void main(String[] args) {
        M994orangesRotting m = new M994orangesRotting();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        m.orangesRotting(grid);
    }
}
