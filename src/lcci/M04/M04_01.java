package lcci.M04;

import java.util.ArrayList;

/**  
 * @ClassName: M04_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月29日  
 *  
 */
public class M04_01 {

    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] _graph = new ArrayList[n];

            for (int i = 0; i < n; ++i) {
                _graph[i] = new ArrayList<>();
            }

            for (int[] each : graph) {
                _graph[each[0]].add(each[1]);
            }

            return dfs(new boolean[n], _graph, start, target);
        }

        public boolean dfs(boolean[] visited, ArrayList<Integer>[] graph, int node, int target) {
            if (node == target) {
                return true;
            }
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            for (int each : graph[node]) {
                if (dfs(visited, graph, each, target)) {
                    return true;
                }
            }
            visited[node] = false;
            return false;
        }
    }

}
