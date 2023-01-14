package old._1000_1099;

/**  
 * @ClassName: _1027  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _1027 {

    class Solution {

        public int longestArithSeqLength(int[] A) {

            int[][] dp  = new int[A.length][20001];

            int     max = 0;

            for (int i = 1; i < A.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    int diff = A[i] - A[j] + 10000;
                    dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                    max         = Math.max(max, dp[i][diff]);
                }
            }

            return max + 1;
        }
    }

}
