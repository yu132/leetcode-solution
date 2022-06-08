package lcof;

/**  
 * @ClassName: M10_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M10_1 {

    class Solution {

        public int fib(int n) {
            int[] dp  = new int[] {0, 1};
            int   now = 0;

            if (n < 2) {
                return dp[n];
            }

            for (int i = 2; i <= n; ++i, now ^= 1) {
                dp[now] = (dp[0] + dp[1]) % 1000000007;
            }

            return dp[now ^ 1];
        }
    }

    public static void main(String[] args) {
        new M10_1().new Solution().fib(5);
    }

}
