package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1137  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1137 {

    class Solution {
        public int tribonacci(int n) {
            int[] dp = new int[Math.max(3, n + 1)];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            return dp[n];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.tribonacci(4));
        Assert.assertEquals(1389537, s.tribonacci(25));
    }
}
