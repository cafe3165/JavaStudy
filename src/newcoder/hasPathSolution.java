package newcoder;

public class hasPathSolution {

    boolean visited[] = null;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (subHas(matrix, rows, cols, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean subHas(char[] matrix, int rows, int cols, char[] str, int row, int col, int len) {
        if (matrix[row * cols + col] != str[len] || visited[row * cols + col] == true) {
            return false;
        }

        if (len == str.length - 1) {
            return true;
        }
        visited[row * cols + col] = true;
        if (row > 0 && subHas(matrix, rows, cols, str, row - 1, col, len + 1)) {
            return true;
        }
        if (row < rows - 1 && subHas(matrix, rows, cols, str, row + 1, col, len + 1)) {
            return true;
        }

        if (col > 0 && subHas(matrix, rows, cols, str, row, col - 1, len + 1)) {
            return true;
        }
        if (col < cols - 1 && subHas(matrix, rows, cols, str, row, col + 1, len + 1)) {
            return true;
        }


        visited[row * cols + col]=false;
        return false;


    }

    public static void main(String[] args) {
        hasPathSolution h = new hasPathSolution();
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        String m="ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        char[] matrix2=m.toCharArray();
        String s="SLHECCEIDEJFGGFIE";

        int rows = 3, cols = 4;
        int rows2 = 5, cols2 = 8;

        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(matrix2[i * cols+j]+" ");
            }
            System.out.println();
        }


        char[] str = {'b', 'c', 'c', 'e'};
        char[] str2 = {'a', 'b', 'c', 'b'};
        char[] str3=s.toCharArray();
//        boolean f=h.hasPath(matrix, rows, cols, str3);
        boolean f=h.hasPath(matrix2, rows2, cols2, str3);

        System.out.println(f);
    }
}
