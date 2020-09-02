package labuladong.AlgorithmThoght;

public class M0810 {
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean[][] vis;
    int R;
    int C;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        R = image.length;
        C = image[0].length;
        vis = new boolean[R][C];
        int originColor = image[sr][sc];
        dfs(image, sr, sc, newColor, originColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int nc, int oc) {
        if (x < 0 || x >= R || y < 0 || y >= C || vis[x][y]||image[x][y]!=oc) {
            return;
        }
        vis[x][y] = true;
        image[x][y] = nc;
        for (int i = 0; i < dir.length; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            dfs(image, newx, newy, nc,oc);
        }

    }


    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        M0810 m = new M0810();
        m.floodFill(image, sr, sc, newColor);
    }
}
