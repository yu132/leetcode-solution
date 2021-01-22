package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1039  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1039 {

    class Solution {
        public int minScoreTriangulation(int[] A) {
            int[][] dp = new int[A.length][A.length];
            for (int len = 2; len < A.length; ++len) {
                for (int i = 0; i < A.length; ++i) {
                    int j = i + len;
                    if (j >= A.length) {
                        continue;
                    }
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);;
                    }
                }
            }
            return dp[0][A.length - 1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.minScoreTriangulation(new int[] {1, 2, 3}));
        Assert.assertEquals(144, s.minScoreTriangulation(new int[] {3, 7, 4, 5}));
        Assert.assertEquals(13, s.minScoreTriangulation(new int[] {1, 3, 1, 4, 1, 5}));
    }

}
