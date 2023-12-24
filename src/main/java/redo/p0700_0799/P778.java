package redo.p0700_0799;

import java.util.Arrays;
import java.util.HashMap;

public class P778 {

    class Solution {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            int n2 = n * n;
            int[] dir = new int[]{-1, 0, 1, 0, -1};
            RankedUnionFind uf = new RankedUnionFind(n * n);
            HashMap<Integer, Node> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    map.put(grid[i][j], new Node(i, j));
                }
            }
            for (int t = 0; t < n2; ++t) {
                Node now = map.get(t);
                int x = now.x, y = now.y;
                for (int d = 1; d < dir.length; ++d) {
                    int x1 = x + dir[d - 1], y1 = y + dir[d];
                    if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n) {
                        continue;
                    }
                    if (grid[x1][y1] < t) {
                        uf.union(x1 * n + y1, x * n + y);
                    }
                }
                if (uf.find(0) == uf.find(n2 - 1)) {
                    return t;
                }
            }
            return -1;
        }

        class Node {
            int x, y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public class RankedUnionFind {
            int connectedComponentCount, rank[], parent[];

            public RankedUnionFind(int num) {
                super();
                rank = new int[num];
                Arrays.fill(rank, 1);
                parent = new int[num];
                Arrays.setAll(parent, (x) -> x);
                connectedComponentCount = num;
            }

            public void union(int x, int y) {
                int typeX = find(x), typeY = find(y);
                if (typeX == typeY) {
                    return;
                }
                if (rank[typeX] > rank[typeY]) {
                    parent[typeY] = typeX;
                } else if (rank[typeX] < rank[typeY]) {
                    parent[typeX] = typeY;
                } else {
                    parent[typeY] = typeX;
                    rank[typeX] += 1;
                }
                --connectedComponentCount;
            }

            public int find(int x) {
                return parent[x] == x ? x : (parent[x] = find(parent[x]));
            }

            public boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            public int connectedComponentCount() {
                return connectedComponentCount;
            }
        }
    }

}
