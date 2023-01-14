package redo.zhousai;

import java.util.Arrays;

public class P6106 {

    class Solution {
        public long countPairs(int n, int[][] edges) {
            RankedUnionFind uf = new RankedUnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            int[] count = new int[n];
            for (int i = 0; i < n; ++i) {
                ++count[uf.find(i)];
            }
            long ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += (long) (n - count[i]) * count[i];
            }
            return ans / 2;
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
                    parent[typeX] = y;
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
