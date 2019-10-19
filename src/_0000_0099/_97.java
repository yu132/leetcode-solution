package _0000_0099;

public class _97 {
	
	class Solution {
		
		byte[][] dp;
		
		public boolean dp(int i1, int i2, String s1, String s2, String s3) {
			if (i1 == s1.length() && i2 == s2.length()) {
				return true;
			}
			if (i1 > s1.length() || i2 > s2.length()) {
				return false;
			}
			if (dp[i1][i2] == 1) {
				return true;
			} else if (dp[i1][i2] == -1) {
				return false;
			}
			if (i1 != s1.length() && s1.charAt(i1) == s3.charAt(i1 + i2)) {
				if (dp(i1 + 1, i2, s1, s2, s3)) {
					dp[i1][i2] = 1;
					return true;
				} else {
					dp[i1][i2] = -1;
				}
			}
			if (i2 != s2.length() && s2.charAt(i2) == s3.charAt(i1 + i2)) {
				if (dp(i1, i2 + 1, s1, s2, s3)) {
					dp[i1][i2] = 1;
					return true;
				} else {
					dp[i1][i2] = -1;
				}
			}
			return false;
		}
		
		public boolean isInterleave(String s1, String s2, String s3) {
			if (s1.length() + s2.length() != s3.length()) {
				return false;
			}
			dp = new byte[s1.length() + 1][s2.length() + 1];
			return dp(0, 0, s1, s2, s3);
		}
	}
	
	public static void main(String[] args) {
		new _97().new Solution().isInterleave("aabcc",
				"dbbca",
				"aadbbcbcac");
	}
	
}
