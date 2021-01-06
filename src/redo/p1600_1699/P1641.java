package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1641  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1641 {

    class Solution {

        int[][] dp;

        public int countVowelStrings(int n) {
            dp = new int[5][n + 1];
            for (int i = 0; i < 5; ++i) {
                dp[i][1] = i + 1;
            }
            return dp(4, n);
        }

        public int dp(int before, int len) {
            if (dp[before][len] == 0) {
                for (int i = 0; i <= before; ++i) {
                    dp[before][len] += dp(i, len - 1);
                }
            }
            return dp[before][len];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.countVowelStrings(1));
        Assert.assertEquals(15, s.countVowelStrings(2));
        Assert.assertEquals(66045, s.countVowelStrings(33));
    }

}
