package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P802  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月1日  
 *  
 */
public class P802 {

    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] state = new int[n];
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                if (dfs(i, state, graph) == 2) {
                    ans.add(i);
                }
            }

            return ans;
        }

        // state 0 no visit; 1 visiting, 2 visited; 3 in cycle;
        int dfs(int index, int[] state, int[][] graph) {
            if (state[index] == 1) {
                state[index] = 3;
            }
            if (state[index] != 0) {
                return state[index];
            }
            state[index] = 1;
            for (int child : graph[index]) {
                if (dfs(child, state, graph) == 3) {
                    return 3;
                }
            }
            return state[index] = 2;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(2, 4, 5, 6), s.eventualSafeNodes(
            Arrs.build2D("[[1,2],[2,3],[5],[0],[5],[],[]]")));
    }

}
