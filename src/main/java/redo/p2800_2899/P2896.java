package redo.p2800_2899;

import java.util.ArrayList;
import java.util.List;

public class P2896 {

    class Solution {
        public int minOperations(String s1, String s2, int x) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    list.add(i);
                }
            }
            int n = list.size();
            if ((n & 1) == 1) {
                return -1;
            }
            if (n == 0) {
                return 0;
            }
            int[][] dp = new int[n][n];
            for (int i = 1; i < n; ++i) {
                dp[i - 1][i] = cal(list.get(i - 1), list.get(i), x);
            }
            for (int l = 4; l <= n; l += 2) {
                for (int i = l; i <= n; ++i) {
                    dp[i - l][i - 1] = Math.min(Math.min(dp[i - l][i - 3] + dp[i - 2][i - 1], dp[i - l][i - l + 1] + dp[i - l + 2][i - 1]), dp[i - l + 1][i - 2] + cal(list.get(i - l), list.get(i - 1), x));
                }
            }
            return dp[0][n - 1];
        }

        int cal(int i, int j, int x) {
            return Math.min(j - i, x);
        }
    }

    public static void main(String[] args) {
        new P2896().new Solution().minOperations("100010010100111100001110101111100001001101011010100111101011100100011111110001011001001", "000001100010010011111101100101111011101110010001001010100101011100011110000111010011010", 6);
    }

}
