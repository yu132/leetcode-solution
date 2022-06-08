package redo.p1000_1099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P1042  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1042 {

    class Solution {
        public int[] gardenNoAdj(int n, int[][] paths) {
            List<Integer>[] adjacency = toAdjacency(n + 1, paths);

            int[] ans = new int[n];

            for (int i = 1; i <= n; ++i) {
                paint(i, ans, adjacency);
            }

            return ans;
        }

        void paint(int point, int[] ans, List<Integer>[] adjacency) {
            boolean[] used = new boolean[5];
            for (int child : adjacency[point]) {
                if (ans[child - 1] != 0) {
                    used[ans[child - 1]] = true;
                }
            }
            for (int color = 1; color <= 4; ++color) {
                if (used[color]) {
                    continue;
                }
                ans[point - 1] = color;
                break;
            }
        }

        public List<Integer>[] toAdjacency(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adjacency[edge[0]].add(edge[1]);
                adjacency[edge[1]].add(edge[0]);
            }

            return adjacency;
        }
    }

}
