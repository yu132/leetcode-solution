package _0800_0899;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _802  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月21日  
 *  
 */
public class _802 {

    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {

            List<Integer> ans  = new ArrayList<>();

            int[]         type = new int[graph.length];

            for (int i = 0; i < graph.length; ++i) {
                if (dfs(graph, i, type) == 2) {
                    ans.add(i);
                }
            }

            return ans;
        }

        public int dfs(int[][] graph, int index, int[] state) {
            if (state[index] == 1) {
                return 3;
            }
            if (state[index] != 0) {
                return state[index];
            }
            state[index] = 1;
            for (int next : graph[index]) {
                if (dfs(graph, next, state) == 3) {
                    state[next] = 3;
                    return 3;
                }
            }
            state[index] = 2;
            return 2;
        }
    }


    public static void main(String[] args) {
        System.out
            .println(new _802().new Solution().eventualSafeNodes(new int[][] {{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}}));
    }
}


