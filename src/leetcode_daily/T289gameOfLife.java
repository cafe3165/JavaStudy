package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class T289gameOfLife {
    public static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count=0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    count+=board[x][y]&1;

                }

                if((board[i][j]&1)>0){
                    if(count>=2&&count<=3){
                        board[i][j]=0b11;
                    }
                }else if((board[i][j]&1)==0&&count==3){
                        board[i][j]=0b10;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j]>>=1;
            }
        }

//        System.out.println(board);
    }

    public static void main(String[] args) {
        T289gameOfLife t = new T289gameOfLife();
        int[][] board = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        t.gameOfLife(board);
    }

}
