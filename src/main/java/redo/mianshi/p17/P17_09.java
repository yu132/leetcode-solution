package redo.mianshi.p17;

/**  
 * @ClassName: P17_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_09 {

    class Solution {
        public int getKthMagicNumber(int k) {
            int i3 = 0, i5 = 0, i7 = 0, i = 1;
            int[] dp = new int[k];
            dp[0] = 1;
            while (--k != 0) {
                dp[i] = Math.min(Math.min(dp[i3] * 3, dp[i5] * 5), dp[i7] * 7);

                if (dp[i] == dp[i3] * 3) {
                    ++i3;
                }
                if (dp[i] == dp[i5] * 5) {
                    ++i5;
                }
                if (dp[i] == dp[i7] * 7) {
                    ++i7;
                }
                ++i;
            }
            return dp[dp.length - 1];
        }
    }

}
