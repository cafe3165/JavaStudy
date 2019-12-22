package newcoder;

public class movingCountSolution {
    private final int dRow[] = {1, -1, 0, 0};
    private final int dCol[] = {0, 0, 1, -1};

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] vis = new boolean[rows][cols];
        return move(threshold, rows, cols, 0, 0, vis) + 1;

    }

    public int move(int threshold, int rows, int cols, int row, int col, boolean[][] vis) {

        vis[row][col] = true;
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int Row = row + dRow[i];
            int Col = col + dCol[i];
            if (Row >= 0 && Col >= 0 && Row < rows && Col < cols && !vis[Row][Col] && tran(Row) + tran(Col) <= threshold) {
                ans += move(threshold, rows, cols, Row, Col, vis) + 1;
            }
        }
        return ans;

    }

    public int tran(int x) {


        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;

    }

    public static void main(String[] args) {

        int threshol = 5, rows = 10, cols = 10;

        movingCountSolution m = new movingCountSolution();
        int count = m.movingCount(threshol, rows, cols);
        System.out.println(count);

    }
}
