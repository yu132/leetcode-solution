package redo.p2000_2099;

public class P2002 {

    class Solution {

        int maxAns = 0;

        public int maxProduct(String s) {
            helper(0, s, new StringBuilder(), new StringBuilder());
            return maxAns;
        }

        public void helper(int index, String s, StringBuilder buf1, StringBuilder buf2) {
            if (index == s.length()) {
                int p1 = longestPalindromeSubseq(buf1.toString()),
                        p2 = longestPalindromeSubseq(buf2.toString());
                maxAns = Math.max(maxAns, p1 * p2);
                return;
            }
            buf1.append(s.charAt(index));
            helper(index + 1, s, buf1, buf2);
            buf1.deleteCharAt(buf1.length() - 1);

            buf2.append(s.charAt(index));
            helper(index + 1, s, buf1, buf2);
            buf2.deleteCharAt(buf2.length() - 1);
        }

        public int longestPalindromeSubseq(String s) {

            if (s.length() == 0) {
                return 0;
            }

            int n = s.length();

            int[][] dp = new int[n][n];

            for (int i = 0; i < n; ++i) {
                dp[i][i] = 1;
            }

            for (int i = 1; i < n; ++i) {
                for (int j = 0; j + i < n; ++j) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                    } else {
                        dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i]);
                    }
                }
            }

            return dp[0][n - 1];
        }
    }


}
