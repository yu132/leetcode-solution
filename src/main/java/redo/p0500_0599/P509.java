package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P509  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P509 {

    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; ++i) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.fib(2));
        assertEquals(2, s.fib(3));
        assertEquals(3, s.fib(4));
        assertEquals(5, s.fib(5));
    }

}
