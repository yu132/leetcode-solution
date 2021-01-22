package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1277  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1277 {

    static//

    class Solution {
        public int countSquares(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length, ans = 0;
            int[][] dp = new int[2][n];
            for (int i = 0, roll = 0; i < m; ++i, roll ^= 1) {
                for (int j = 0; j < n; ++j) {
                    if (i == 0 || j == 0) {
                        dp[roll][j] = matrix[i][j];
                    } else if (matrix[i][j] == 0) {
                        dp[roll][j] = 0;
                    } else {
                        dp[roll][j] = min(dp[roll][j - 1], dp[roll ^ 1][j], dp[roll ^ 1][j - 1]) + 1;
                    }
                    ans += dp[roll][j];
                }
            }
            return ans;
        }

        public static int min(int... nums) {
            int min = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                min = Math.min(min, nums[i]);
            }
            return min;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(15, s.countSquares(Arrs.build2D("[[0,1,1,1],[1,1,1,1],[0,1,1,1]]")));
        Assert.assertEquals(7, s.countSquares(Arrs.build2D("[[1,0,1],[1,1,0],[1,1,0]]")));
    }

}
