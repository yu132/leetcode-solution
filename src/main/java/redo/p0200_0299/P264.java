package redo.p0200_0299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P264  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P264 {

    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n];
            int i2 = 0, i3 = 0, i5 = 0;
            dp[0] = 1;
            for (int i = 1; i < n; ++i) {
                dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
                if (dp[i] == dp[i2] * 2) {
                    ++i2;
                }
                if (dp[i] == dp[i3] * 3) {
                    ++i3;
                }
                if (dp[i] == dp[i5] * 5) {
                    ++i5;
                }
            }
            return dp[n - 1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2123366400, s.nthUglyNumber(1690));
    }


}
