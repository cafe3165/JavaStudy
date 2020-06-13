package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-13
 */
public class T79exist {
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] vis;
    private int C;
    private int R;
    private char[][] Board;
    private String Word;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        R = board.length;
        C = board[0].length;
        Board = board;
        Word = word;
        vis = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (search(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int x, int y, int start) {
        if (start == Word.length() - 1) {
            return Board[x][y] == Word.charAt(start);
        }

        if (Board[x][y] == Word.charAt(start)) {
            vis[x][y] = true;
            for (int i = 0; i < dir.length; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C && !vis[newX][newY]) {
                    if (search(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            vis[x][y] = false;
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        T79exist t = new T79exist();
        String word = "SEE";
        t.exist(board, word);

    }
}
