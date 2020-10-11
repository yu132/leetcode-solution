package _1000_1099;

/**  
 * @ClassName: _1035  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _1035 {

    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int[][] dp = new int[A.length + 1][B.length + 1];
            for (int i = 1; i <= A.length; ++i) {
                for (int j = 1; j <= B.length; ++j) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[A.length][B.length];
        }
    }

}
