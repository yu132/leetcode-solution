package redo.p0000_0099;

/**  
 * @ClassName: P97  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P97 {

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {

            int m = s1.length(), n = s2.length();

            if (m + n != s3.length()) {
                return false;
            }

            boolean[][] dp = new boolean[m + 1][n + 1];

            dp[0][0] = true;

            for (int i = 0; i <= m; ++i) {
                for (int j = 0; j <= n; ++j) {
                    int k = i + j;
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }

            return dp[m][n];
        }
    }

}
