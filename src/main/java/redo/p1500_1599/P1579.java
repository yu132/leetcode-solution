package redo.p1500_1599;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P1579 {

    class Solution {
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            RankedUnionFind uf = new RankedUnionFind(n);
            int ans = 0;
            for (int[] edge : edges) {
                if (edge[0] == 3) {
                    if (uf.isConnected(edge[1] - 1, edge[2] - 1)) {
                        ++ans;
                    }
                    uf.union(edge[1] - 1, edge[2] - 1);
                }
            }
            RankedUnionFind copy = new RankedUnionFind(uf);

            for (int[] edge : edges) {
                if (edge[0] == 1) {
                    if (uf.isConnected(edge[1] - 1, edge[2] - 1)) {
                        ++ans;
                    }
                    uf.union(edge[1] - 1, edge[2] - 1);
                }
            }

            if (uf.connectedComponentCount != 1) {
                return -1;
            }

            for (int[] edge : edges) {
                if (edge[0] == 2) {
                    if (copy.isConnected(edge[1] - 1, edge[2] - 1)) {
                        ++ans;
                    }
                    copy.union(edge[1] - 1, edge[2] - 1);
                }
            }

            if (copy.connectedComponentCount != 1) {
                return -1;
            }

            return ans;
        }

        public class RankedUnionFind {
            int connectedComponentCount, rank[], parent[];

            public RankedUnionFind(RankedUnionFind toCopy) {
                connectedComponentCount = toCopy.connectedComponentCount;
                rank = Arrays.copyOf(toCopy.rank, toCopy.rank.length);
                parent = Arrays.copyOf(toCopy.parent, toCopy.parent.length);
            }

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

    public static void main(String[] args) {
        new P1579().new Solution().maxNumEdgesToRemove(4, Arrs.build2D("[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]"));
    }

}
