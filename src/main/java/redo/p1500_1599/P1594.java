package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1594  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1594 {

    // 此问题不能提前求模，因为求模会影响大小，进而影响最终的结果，由于过程中要求MAX和MIN，因此影响是存在的
    class Solution {

        private final static int MOD = 1000000007;

        public int maxProductPath(int[][] grid) {
            long[][] dp = new long[grid[0].length][2];
            dp[0][0] = grid[0][0];
            dp[0][1] = grid[0][0];
            for (int i = 1; i < grid[0].length; ++i) {
                dp[i][0] = dp[i][1] = (dp[i - 1][0] * grid[0][i]);
            }
            for (int i = 1; i < grid.length; ++i) {
                if (i != 0) {
                    dp[0][1] = dp[0][0] = (dp[0][0] * grid[i][0]);
                }
                for (int j = 1; j < grid[0].length; ++j) {
                    long n1 = dp[j - 1][0] * grid[i][j], n2 = dp[j - 1][1] * grid[i][j], //
                        n3 = grid[i][j] * dp[j][1], n4 = grid[i][j] * dp[j][0];
                    dp[j][0] = Math.max(Math.max(n1, n2), Math.max(n3, n4));
                    dp[j][1] = Math.min(Math.min(n1, n2), Math.min(n3, n4));
                }
            }
            if (dp[grid[0].length - 1][0] < 0) {
                return -1;
            }
            return (int)(dp[grid[0].length - 1][0] % MOD);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(-1, s.maxProductPath(Arrs.build2D("[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]")));
        Assert.assertEquals(8, s.maxProductPath(Arrs.build2D("[[1,-2,1],[1,-2,1],[3,-4,1]]")));
        Assert.assertEquals(0, s.maxProductPath(Arrs.build2D("[[1,3],[0,-4]]")));
        Assert.assertEquals(2, s.maxProductPath(Arrs.build2D("[[1,4,4,0],[-2,0,0,1],[1,-1,1,1]]")));
        Assert.assertEquals(999300007, s.maxProductPath(Arrs.build2D("[[10000000],[10000000]]")));
        Assert.assertEquals(31136867, s.maxProductPath(Arrs.build2D(
            "[[1,-1,0,-3,4,3,-3,3,-1,3,0,0,-4,2],[2,-2,-3,-4,0,-2,-3,3,1,4,1,-3,-1,-4],[-4,4,-4,-4,2,-4,3,0,-2,-4,3,4,-1,0],[-3,3,-4,-4,3,4,4,1,-1,-1,0,3,4,1],[1,3,-4,2,2,-3,1,-3,-4,-4,-1,-4,-4,4],[1,1,-1,1,-1,-1,3,-4,-1,2,-2,3,-4,0],[1,0,3,3,1,4,1,1,-4,-1,-3,4,-4,4],[4,3,2,3,0,-1,2,-4,1,0,0,1,3,4],[-4,4,-4,-4,2,-2,2,-1,0,-2,2,4,-2,-1],[-2,3,4,-4,3,3,-2,-1,0,-3,4,-2,-1,-4],[4,3,3,3,-3,1,2,-4,-1,4,-3,-3,2,0],[3,3,0,1,-4,-4,-3,3,-2,-4,2,4,-3,3],[-3,0,1,3,0,0,0,-4,-1,4,-1,-3,1,1],[-1,4,0,-3,1,-3,-1,2,1,-3,-1,-4,4,1]]")));
    }

}
