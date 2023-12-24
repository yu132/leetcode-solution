package redo.p0800_0899;

import java.util.Arrays;

public class P839 {

    class Solution {
        public int numSimilarGroups(String[] strs) {
            RankedUnionFind uf = new RankedUnionFind(strs.length);
            for (int i = 0; i < strs.length; ++i) {
                for (int j = i + 1; j < strs.length; ++j) {
                    if (isEquals(strs[i], strs[j])) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.connectedComponentCount;
        }

        boolean isEquals(String str1, String str2) {
            int count = 0;
            for (int i = 0; i < str1.length(); ++i) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    ++count;
                }
            }
            return count <= 2;
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
