package redo.p2600_2699;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P2685 {

    class Solution {
        public int countCompleteComponents(int n, int[][] edges) {
            WeightedUnionFind uf = new WeightedUnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            int[] counter = new int[n];
            for (int[] edge : edges) {
                ++counter[uf.find(edge[0])];
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i == uf.find(i)) {
                    if (counter[i] == uf.weight[i] * (uf.weight[i] - 1) / 2) {
                        ++ans;
                    }
                }
            }
            return ans;
        }

        public class WeightedUnionFind {
            int connectedComponentCount, weight[], parent[];

            public WeightedUnionFind(int num) {
                super();
                weight = new int[num];
                Arrays.fill(weight, 1);
                parent = new int[num];
                Arrays.setAll(parent, (x) -> x);
                connectedComponentCount = num;
            }

            public void union(int x, int y) {
                int typeX = find(x), typeY = find(y);
                if (typeX == typeY) {
                    return;
                }
                if (weight[typeX] >= weight[typeY]) {
                    parent[typeY] = typeX;
                    weight[typeX] += weight[typeY];
                } else {
                    parent[typeX] = y;
                    weight[typeY] += weight[typeX];
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

    public static void main(String[] args) {
        new P2685().new Solution().countCompleteComponents(6, Arrs.build2D("[[0,1],[0,2],[1,2],[3,4]]"));
    }

}
