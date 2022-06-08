package _0100_0199;

/**  
 * @ClassName: _161  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月16日  
 *  
 */
public class _161 {

    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            return editDistance(s, t) == 1;
        }

        public int editDistance(String str1, String str2) {
            if (str1.length() == 0 || str2.length() == 0) {
                return Math.max(str1.length(), str2.length());
            }
            int     len1 = str1.length() + 1, len2 = str2.length() + 1;

            int[][] dp   = new int[len1][len2];

            for (int i = 1; i < len1; ++i) {
                dp[i][0] = i;
            }

            for (int j = 1; j < len2; ++j) {
                dp[0][j] = j;
            }

            for (int i = 1; i < len1; ++i) {
                for (int j = 1; j < len2; ++j) {
                    int change = str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1;
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + change));
                }
            }

            return dp[len1 - 1][len2 - 1];
        }
    }

}
