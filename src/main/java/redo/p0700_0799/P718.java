package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P718  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P718 {

    class Solution {
        public int findLength(int[] A, int[] B) {
            int[][] dp = new int[2][B.length + 1];

            int scroll = 0, max = 0;
            for (int i = 1; i <= A.length; ++i, scroll ^= 1) {
                for (int j = 1; j <= B.length; ++j) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[scroll][j] = dp[scroll ^ 1][j - 1] + 1;
                        max = Math.max(max, dp[scroll][j]);
                    } else {
                        dp[scroll][j] = 0;
                    }
                }
            }

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.findLength(new int[] {1, 2, 3, 2, 1}, new int[] {3, 2, 1, 4, 7}));
        Assert.assertEquals(2, s.findLength(new int[] {0, 1, 1, 1, 1}, new int[] {1, 0, 1, 0, 1}));
    }

}
