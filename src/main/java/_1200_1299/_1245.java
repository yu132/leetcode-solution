package _1200_1299;

import java.util.ArrayList;

/**  
 * @ClassName: _1245  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _1245 {

    class Solution {

        int maxLen = 0;
        int val = 0;

        public int treeDiameter(int[][] edges) {
            ArrayList<ArrayList<Integer>> near = new ArrayList<>();

            for (int i = 0; i < edges.length; ++i) {
                while (near.size() <= Math.max(edges[i][0], edges[i][1])) {
                    near.add(new ArrayList<>());
                }
                near.get(edges[i][0]).add(edges[i][1]);
                near.get(edges[i][1]).add(edges[i][0]);
            }

            helper(0, new boolean[near.size()], near, 0);
            maxLen = 0;
            helper(val, new boolean[near.size()], near, 0);
            return maxLen;
        }

        private void helper(int node, boolean[] visited, ArrayList<ArrayList<Integer>> near, int depth) {
            if (visited[node]) {
                return;
            }
            visited[node] = true;
            if (depth > maxLen) {
                val    = node;
                maxLen = depth;
            }
            for (int next : near.get(node)) {
                helper(next, visited, near, depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        new _1245().new Solution().treeDiameter(new int[][] {{0, 1}, {0, 2}});
    }
}
