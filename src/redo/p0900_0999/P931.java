package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P931  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P931 {

    class Solution {
        public int minFallingPathSum(int[][] A) {
            int n = A.length;

            if (n == 1) {
                return A[0][0];
            }

            int[][] dp = new int[2][n];
            int scroll = 0;
            for (int i = 0; i < n; ++i, scroll ^= 1) {
                dp[scroll][0] = Math.min(dp[scroll ^ 1][0], dp[scroll ^ 1][1]) + A[i][0];
                for (int j = 1; j < n - 1; ++j) {
                    dp[scroll][j] =
                        Math.min(Math.min(dp[scroll ^ 1][j - 1], dp[scroll ^ 1][j]), dp[scroll ^ 1][j + 1]) + A[i][j];
                }
                dp[scroll][n - 1] = Math.min(dp[scroll ^ 1][n - 2], dp[scroll ^ 1][n - 1]) + A[i][n - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                min = Math.min(min, dp[scroll ^ 1][i]);
            }
            return min;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12, s.minFallingPathSum(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]")));
        Assert.assertEquals(69, s.minFallingPathSum(Arrs.build2D("[[69]]")));
    }

}
