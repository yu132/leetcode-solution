package redo.p0700_0799;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: P785  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P785 {

    static//

    class Solution {
        public boolean isBipartite(int[][] graph) {

            int n = graph.length;

            Set<Integer> visited = new HashSet<>();

            UnionFind uf = new UnionFind(n + 2);

            for (int i = 0; i < n; ++i) {
                if (!visited.contains(i)
                    && !dfs(i, n, n + 1, visited, graph, uf)) {
                    return false;
                }
            }

            return true;
        }

        boolean dfs(int node, int color, int otherColor, Set<Integer> visited,
            int[][] graph, UnionFind uf) {

            if (uf.isConnected(node, otherColor)) {
                return false;
            }

            if (visited.contains(node)) {
                return true;
            }

            visited.add(node);

            uf.union(node, color);

            for (int child : graph[node]) {
                if (!dfs(child, otherColor, color, visited, graph, uf)) {
                    return false;
                }
            }

            return true;
        }

        static class UnionFind {
            int[] parent, rank;

            UnionFind(int len) {
                parent = new int[len];
                rank = new int[len];
                Arrays.setAll(parent, (x) -> x);
            }

            void union(int x, int y) {
                int tx = find(x), ty = find(y);

                if (tx == ty) {
                    return;
                }

                if (rank[tx] >= rank[ty]) {
                    parent[ty] = tx;
                    if (rank[tx] == rank[ty]) {
                        ++rank[tx];
                    }
                } else {
                    parent[tx] = ty;
                }
            }

            boolean isConnected(int x, int y) {
                return find(x) == find(y);
            }

            int find(int x) {
                return parent[x] == x ? x : (parent[x] = find(parent[x]));
            }
        }
    }

}
