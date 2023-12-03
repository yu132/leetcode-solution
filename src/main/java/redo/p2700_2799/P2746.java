package redo.p2700_2799;

public class P2746 {

    class Solution {
        public int minimizeConcatenatedLength(String[] words) {
            int n = words.length;
            int[][][] dp = new int[n][26][26];

            for (int i = 0; i < words.length; ++i) {
                for (int j = 0; j < 26; ++j) {
                    for (int k = 0; k < 26; ++k) {
                        dp[i][j][k] = Integer.MAX_VALUE / 10;
                    }
                }
            }

            dp[0][first(words[0])][last(words[0])] = words[0].length();

            for (int i = 1; i < words.length; ++i) {
                for (int j = 0; j < 26; ++j) {
                    for (int k = 0; k < 26; ++k) {

                        dp[i][first(words[i])][k] = Math.min(dp[i][first(words[i])][k],
                                dp[i - 1][j][k] + (j == last(words[i]) ? -1 : 0) + words[i].length());

                        dp[i][j][last(words[i])] = Math.min(dp[i][j][last(words[i])],
                                dp[i - 1][j][k] + (k == first(words[i]) ? -1 : 0) + words[i].length());
                    }
                }
            }

            int ans = Integer.MAX_VALUE;

            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    ans = Math.min(ans, dp[words.length - 1][j][k]);
                }
            }

            return ans;
        }

        int first(String word) {
            return word.charAt(0) - 'a';
        }

        int last(String word) {
            return word.charAt(word.length() - 1) - 'a';
        }
    }

    public static void main(String[] args) {
        new P2746().new Solution().minimizeConcatenatedLength(new String[]{"aa", "ab", "bc"});
    }

}
