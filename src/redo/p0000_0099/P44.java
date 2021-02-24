package redo.p0000_0099;

/**  
 * @ClassName: P44  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P44 {

    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] |= (i > 0 && dp[i - 1][j]) || dp[i][j - 1];
                    } else if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?')) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                }
            }

            return dp[m][n];
        }
    }

}
