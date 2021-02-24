package redo.offer2.p08;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P08_11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_11 {

    static//

    class Solution {

        final static int[] MONEY = {1, 5, 10, 25};

        final static int MOD = 1000000007;

        public int waysToChange(int n) {

            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 0; i < 4; ++i) {
                for (int j = MONEY[i]; j <= n; ++j) {
                    dp[j] = (dp[j] + dp[j - MONEY[i]]) % MOD;
                }
            }

            return dp[n];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.waysToChange(124234));
    }

}
