package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P19  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P19 {

    class Solution {
        public boolean isMatch(String s, String p) {
            return helper(s.length(), p.length(), s, p);
        }

        public boolean helper(int i, int j, String s, String p) {
            if (i == 0 && j == 0) {
                return true;
            }
            if (j == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '*') {
                if (helper(i, j - 2, s, p)) {
                    return true;
                }
                if (match(s, p, i, j - 1) && helper(i - 1, j, s, p)) {
                    return true;
                }
            } else {
                if (match(s, p, i, j) && helper(i - 1, j - 1, s, p)) {
                    return true;
                }
            }
            return false;
        }

        public boolean match(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }

    }

    // class Solution {
    // public boolean isMatch(String s, String p) {
    //
    // int m = s.length(), n = p.length();
    //
    // boolean[][] dp = new boolean[2][n + 1];
    //
    // int scroll = 0;
    //
    // dp[0][0] = true;
    //
    // for (int i = 0; i <= m; ++i, scroll ^= 1, dp[scroll][0] = false) {
    // for (int j = 1; j <= n; ++j) {
    // dp[scroll][j] = false;
    // if (p.charAt(j - 1) == '*') {
    // dp[scroll][j] = dp[scroll][j - 2];
    // if (match(s, p, i, j - 1)) {
    // dp[scroll][j] |= dp[scroll ^ 1][j];
    // }
    // } else {
    // if (match(s, p, i, j)) {
    // dp[scroll][j] = dp[scroll ^ 1][j - 1];
    // }
    // }
    // }
    // }
    // return dp[scroll ^ 1][n];
    // }
    //
    // public boolean match(String s, String p, int i, int j) {
    // if (i == 0) {
    // return false;
    // }
    // if (p.charAt(j - 1) == '.') {
    // return true;
    // }
    // return s.charAt(i - 1) == p.charAt(j - 1);
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.isMatch("aa", "a"));
        Assert.assertEquals(true, s.isMatch("aa", "a*"));
        Assert.assertEquals(true, s.isMatch("ab", ".*"));
        Assert.assertEquals(true, s.isMatch("aab", "c*a*b"));
        Assert.assertEquals(false, s.isMatch("mississippi", "mis*is*p*."));
        Assert.assertEquals(false, s.isMatch("abcd", "d*"));
    }

}
