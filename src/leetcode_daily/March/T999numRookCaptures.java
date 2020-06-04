package leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-26
 */
public class T999numRookCaptures {
    public int numRookCaptures(char[][] board) {
//        找rook
        int rookI = -1, rookJ = -1, pCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rookI = i;
                    rookJ = j;
                    break;

                }
            }
            if (rookI != -1) {
                break;
            }
        }
//向右
        for (int i = rookJ; i < board[0].length; i++) {
            if (board[rookI][i] == 'B') {
                break;
            }
            if (board[rookI][i] == 'p') {
                pCount++;
                break;
            }
        }
//        向左


        for (int i = rookJ; i >= 0; i--) {
            if (board[rookI][i] == 'B') {
                break;
            }
            if (board[rookI][i] == 'p') {
                pCount++;
                break;
            }
        }
//向上
        for (int i = rookI; i >= 0; i--) {
            if (board[i][rookJ] == 'B') {
                break;
            }
            if (board[i][rookJ] == 'p') {
                pCount++;
                break;
            }
        }
//向下
        for (int i = rookI; i<board.length; i++) {
            if (board[i][rookJ] == 'B') {
                break;
            }
            if (board[i][rookJ] == 'p') {
                pCount++;
                break;
            }
        }

        return pCount;
    }


    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {
                '.', '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, {
                '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {
                '.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};


        T999numRookCaptures t = new T999numRookCaptures();

        t.numRookCaptures(board);

    }

}
