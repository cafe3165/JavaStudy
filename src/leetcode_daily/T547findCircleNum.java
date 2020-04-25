package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class T547findCircleNum {
    class uf {
        private int c;
        private int[] parent;
        private int[] size;

        public uf(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            this.c = n;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            } else {
                // 小树接到大树下面，较平衡
                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }

                c--;
            }

        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;

        }

        public int count() {
            return c;
        }

    }


    public int findCircleNum(int[][] M) {
//        int res = 0;
        int n = M.length;
        uf u = new uf(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j]==1){
                    u.union(i,j);
                }
            }
        }

        return u.count();
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};

        T547findCircleNum t = new T547findCircleNum();
        t.findCircleNum(M);
    }

}
