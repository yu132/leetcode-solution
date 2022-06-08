package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1035  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1035 {

    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int[][] dp = new int[2][B.length + 1];

            int scroll = 0;
            for (int i = 1; i <= A.length; ++i, scroll ^= 1) {
                for (int j = 1; j <= B.length; ++j) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[scroll][j] = dp[scroll ^ 1][j - 1] + 1;
                    } else {
                        dp[scroll][j] = Math.max(dp[scroll ^ 1][j], dp[scroll][j - 1]);
                    }
                }
            }

            return dp[scroll ^ 1][B.length];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxUncrossedLines(new int[] {1, 4, 2}, new int[] {1, 2, 4}));
        Assert.assertEquals(3, s.maxUncrossedLines(new int[] {2, 5, 1, 2, 5}, new int[] {10, 5, 2, 1, 5, 2}));
        Assert.assertEquals(2, s.maxUncrossedLines(new int[] {1, 3, 7, 1, 7, 5}, new int[] {1, 9, 2, 5, 1}));
    }

}
