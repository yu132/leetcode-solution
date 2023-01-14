package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P2492 {

    class Solution {
        public int minScore(int n, int[][] roads) {
            int[] minOfType = new int[n + 1];
            RankedUnionFind uf = new RankedUnionFind(n + 1);
            Arrays.fill(minOfType, Integer.MAX_VALUE);
            for (int[] road : roads) {
                int t1 = uf.find(road[0]), t2 = uf.find(road[1]);
                uf.union(road[0], road[1]);
                int type = uf.find(road[0]);
                minOfType[type] = Math.min(minOfType[type], road[2]);
                minOfType[type] = Math.min(minOfType[type], minOfType[t1]);
                minOfType[type] = Math.min(minOfType[type], minOfType[t2]);
            }
            return minOfType[uf.find(1)];
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

    public static void main(String[] args) {
        new P2492().new Solution().minScore(7, Arrs.build2D("[[1,3,1484],[3,2,3876],[2,4,6823],[6,7,579],[5,6,4436],[4,5,8830]]"));
    }

}
