package redo.p0800_0899;

import redo.testUtil.Arrs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P827 {

    class Solution {
        public int largestIsland(int[][] grid) {
            int n = grid.length;
            WeightedUnionFind uf = new WeightedUnionFind(n * n);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    int x = get(i, j, n);
                    if (i < n - 1 && grid[i + 1][j] == 1) {
                        int y = get(i + 1, j, n);
                        uf.union(x, y);
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        int y = get(i, j + 1, n);
                        uf.union(x, y);
                    }
                }
            }
            if (uf.connectedComponentCount == 1) {
                return n * n;
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) {
                        continue;
                    }
                    int sum = 0;
                    Set<Integer> visited = new HashSet<>();
                    if (i > 0 && grid[i - 1][j] == 1) {
                        int y = get(i - 1, j, n);
                        int type = uf.find(y);
                        if (!visited.contains(type)) {
                            sum += uf.getWeight(y);
                            visited.add(type);
                        }
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        int y = get(i, j - 1, n);
                        int type = uf.find(y);
                        if (!visited.contains(type)) {
                            sum += uf.getWeight(y);
                            visited.add(type);
                        }
                    }
                    if (i < n - 1 && grid[i + 1][j] == 1) {
                        int y = get(i + 1, j, n);
                        int type = uf.find(y);
                        if (!visited.contains(type)) {
                            sum += uf.getWeight(y);
                            visited.add(type);
                        }
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        int y = get(i, j + 1, n);
                        int type = uf.find(y);
                        if (!visited.contains(type)) {
                            sum += uf.getWeight(y);
                            visited.add(type);
                        }
                    }
                    ans = Math.max(ans, sum + 1);
                }
            }
            return ans;
        }

        int get(int i, int j, int n) {
            return i * n + j;
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
                    parent[typeX] = typeY;
                    weight[typeY] += weight[typeX];
                }
                --connectedComponentCount;
            }

            public int getWeight(int x) {
                return weight[find(x)];
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
        new P827().new Solution().largestIsland(Arrs.build2D("[[0,0],[0,0]]"));
    }

}
