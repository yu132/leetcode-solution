package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P70  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P70 {

    class Solution {

        int[] dp;

        public int climbStairs(int n) {
            dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            return dp(n);
        }

        public int dp(int n) {
            if (dp[n] == 0) {
                dp[n] = dp(n - 1) + dp(n - 2);
            }
            return dp[n];
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.climbStairs(2));
        assertEquals(3, s.climbStairs(3));
    }
}
