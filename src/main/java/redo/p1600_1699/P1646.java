package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1646  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1646 {

    class Solution {
        public int getMaximumGenerated(int n) {
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[Math.max(2, n + 1)];
            dp[0] = 0;
            dp[1] = 1;
            int max = 1;
            for (int i = 1; i <= n; ++i) {
                if (i % 2 == 0) {
                    dp[i] = dp[i / 2];
                } else {
                    dp[i] = dp[i / 2] + dp[i / 2 + 1];
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.getMaximumGenerated(7));
        Assert.assertEquals(1, s.getMaximumGenerated(2));
        Assert.assertEquals(2, s.getMaximumGenerated(3));
        Assert.assertEquals(21, s.getMaximumGenerated(99));
    }

}
