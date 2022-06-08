package redo.LCP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: LCP07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP07 {

    class Solution {

        private Map<Integer, List<Integer>> graph = new HashMap<>();

        public int numWays(int n, int[][] relation, int k) {
            for (int[] r : relation) {
                graph.computeIfAbsent(r[0], (x) -> new ArrayList<>()).add(r[1]);
            }
            return dfs(0, k, n);
        }

        public int dfs(int loc, int k, int n) {
            if (k == 0) {
                if (loc == n - 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
            int ans = 0;
            for (int des : graph.getOrDefault(loc, Collections.emptyList())) {
                ans += dfs(des, k - 1, n);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numWays(5, Arrs.build2D("[[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]"), 3));
        Assert.assertEquals(0, s.numWays(3, Arrs.build2D("[[0,2],[2,1]]"), 2));

    }

}
