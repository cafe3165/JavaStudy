package leetcode_daily.June;

/**
 * Author:cafe3165
 * Date:2020-06-08
 */
public class T990equationsPossible {
    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int find2(int x) {
            while (x != parent[x]) {
                parent[x] = find2(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }


    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                int left = e.charAt(0) - 'a';
                int right = e.charAt(3) - 'a';
                uf.union(left, right);
            }
        }

        for (String e : equations) {
            if (e.charAt(1) == '!') {
                int left = e.charAt(0) - 'a';
                int right = e.charAt(3) - 'a';
                if (uf.isConnected(left, right)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        T990equationsPossible t = new T990equationsPossible();
        String[] equations = new String[]{"c==c", "b==d", "x!=z"};
        System.out.println(t.equationsPossible(equations));

    }
}
