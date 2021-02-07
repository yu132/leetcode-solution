package redo.Util.ag.editDistance;

/**  
 * @ClassName: EditDistanceUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class EditDistanceUtil {

    public int editDistance(String first, String second) {
        int m = first.length(), n = second.length();

        int[][] dp = new int[2][n + 1];

        for (int i = 1; i <= n; ++i) {
            dp[0][i] = i;
        }

        int scroll = 1;

        for (int i = 1; i <= m; ++i, scroll ^= 1) {
            dp[scroll][0] = i;
            for (int j = 1; j <= n; ++j) {
                int edit = first.charAt(i - 1) == second.charAt(j - 1) ? 0 : 1;
                dp[scroll][j] = Math.min(
                    Math.min(dp[scroll ^ 1][j] + 1, dp[scroll][j - 1] + 1),
                    dp[scroll ^ 1][j - 1] + edit);
            }
        }

        return dp[scroll ^ 1][n];
    }
}
