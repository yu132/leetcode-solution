package redo.p1300_1399;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1376  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1376 {

    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            List<Integer>[] adjacency = toAdjacency(n, manager);
            return dfs(headID, adjacency, informTime);
        }

        int dfs(int now, List<Integer>[] adjacency, int[] informTime) {
            int time = 0;
            for (int child : adjacency[now]) {
                time = Math.max(time, dfs(child, adjacency, informTime));
            }
            return time + informTime[now];
        }

        public List<Integer>[] toAdjacency(int n, int[] parents) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int i = 0; i < parents.length; ++i) {
                if (parents[i] == -1) {
                    continue;
                }
                adjacency[parents[i]].add(i);
            }

            return adjacency;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.numOfMinutes(1, 0, new int[] {-1}, new int[] {0}));
        Assert.assertEquals(1, s.numOfMinutes(6, 2, new int[] {2, 2, -1, 2, 2, 2}, new int[] {0, 0, 1, 0, 0, 0}));
        Assert.assertEquals(21,
            s.numOfMinutes(7, 6, new int[] {1, 2, 3, 4, 5, 6, -1}, new int[] {0, 6, 5, 4, 3, 2, 1}));
        Assert.assertEquals(3, s.numOfMinutes(15, 0, new int[] {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6},
            new int[] {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}));
        Assert.assertEquals(1076, s.numOfMinutes(4, 2, new int[] {3, 3, -1, 2}, new int[] {0, 0, 162, 914}));
    }

}
