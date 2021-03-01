package redo.p0000_0099;

/**  
 * @ClassName: P91  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P91 {

    class Solution {

        int[] dp;

        public int numDecodings(String s) {
            dp = new int[s.length()];
            return backtrack(0, s);
        }

        int backtrack(int index, String s) {

            if (index == s.length()) {
                return 1;
            }

            if (s.charAt(index) == '0') {
                return 0;
            }

            if (dp[index] == 0) {
                int count = backtrack(index + 1, s);

                if (index < s.length() - 1) {

                    int num = (s.charAt(index) - '0') * 10 + s.charAt(index + 1)
                        - '0';

                    if (num <= 26) {
                        count += backtrack(index + 2, s);
                    }
                }
                dp[index] = count;
            }

            return dp[index];
        }
    }

}
