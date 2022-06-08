package _0200_0299;

import java.util.Arrays;

/**  
 * @ClassName: _261  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月9日  
 *  
 */
public class _261 {
    /*
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            boolean[]                   visited = new boolean[n];
            Map<Integer, List<Integer>> graph   = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], (x) -> new ArrayList<>()).add(edge[1]);
                graph.computeIfAbsent(edge[1], (x) -> new ArrayList<>()).add(edge[0]);
            }
            if (!dfs(visited, 0, -1, graph)) {
                return false;
            }
            for (int i = 0; i < visited.length; ++i) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        }
    
        public boolean dfs(boolean[] visited, int now, int before, Map<Integer, List<Integer>> graph) {
            if (visited[now]) {
                return false;
            }
            visited[now] = true;
            for (int next : graph.getOrDefault(now, Collections.emptyList())) {
                if (next == before) {
                    continue;
                }
                if (!dfs(visited, next, now, graph)) {
                    return false;
                }
            }
            return true;
        }
    }
    */


    class Solution {
        public boolean validTree(int n, int[][] edges) {
            UF uf = new UF(n);
            for (int[] edge : edges) {
                if (uf.connected(edge[0], edge[1])) {
                    return false;
                }
                uf.union(edge[0], edge[1]);
            }
            return uf.count == 1;
        }

        public class UF {
            private int[] size;

            protected int count;

            protected int[] uf;

            public boolean connected(int element1, int element2) {
                return find(element1) == find(element2);
            }

            public int count() {
                return count;
            }

            public UF(int typeNumber) {
                this.uf = new int[typeNumber];
                count   = typeNumber;
                for (int i = 0; i < typeNumber; i++) {
                    uf[i] = i;
                }
                size  = new int[typeNumber];
                count = typeNumber;
                Arrays.fill(size, 1);
            }

            public int find(int element) {
                return uf[element] == element ? element : (uf[element] = find(uf[element]));
            }

            public void union(int element1, int element2) {
                int type1 = find(element1);
                int type2 = find(element2);

                if (type1 == type2)
                    return;

                if (size[type1] < size[type2]) {
                    uf[type1]    = type2;
                    size[type2] += size[type1];
                } else {
                    uf[type2]    = type1;
                    size[type1] += size[type2];
                }
                --count;
            }
        }
    }



}
