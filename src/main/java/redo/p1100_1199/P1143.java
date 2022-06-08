package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1143  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1143 {

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] chs1 = text1.toCharArray(), chs2 = text2.toCharArray();
            int[][] dp = new int[2][chs2.length + 1];
            int scroll = 0;
            for (int i = 1; i <= chs1.length; ++i, scroll ^= 1) {
                for (int j = 1; j <= chs2.length; ++j) {
                    if (chs1[i - 1] == chs2[j - 1]) {
                        dp[scroll][j] = dp[scroll ^ 1][j - 1] + 1;
                    } else {
                        dp[scroll][j] = Math.max(dp[scroll ^ 1][j], dp[scroll][j - 1]);
                    }
                }
            }

            return dp[scroll ^ 1][chs2.length];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(3, s.longestCommonSubsequence("abc", "abc"));
        Assert.assertEquals(0, s.longestCommonSubsequence("abc", "def"));
    }

}
