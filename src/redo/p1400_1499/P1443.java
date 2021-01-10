package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1443  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1443 {

    class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            List<Integer>[] adjacency = toAdjacency(n, edges);
            return Math.max(dfs(0, -1, n, adjacency, hasApple) * 2 - 2, 0);
        }

        public int dfs(int now, int parent, int n, List<Integer>[] adjacency, List<Boolean> hasApple) {
            int count = 0;
            for (int child : adjacency[now]) {
                if (child == parent) {
                    continue;
                }
                count += dfs(child, now, n, adjacency, hasApple);
            }
            if (count > 0 || hasApple.get(now)) {
                ++count;
            }
            return count;
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(8, s.minTime(7, Arrs.build2D("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"),
            Arrays.asList(false, false, true, false, true, true, false)));

        Assert.assertEquals(6, s.minTime(7, Arrs.build2D("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"),
            Arrays.asList(false, false, true, false, false, true, false)));

        Assert.assertEquals(0, s.minTime(7, Arrs.build2D("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]"),
            Arrays.asList(false, false, false, false, false, false, false)));
    }

}
