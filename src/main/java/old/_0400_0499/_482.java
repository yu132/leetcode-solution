package old._0400_0499;

public class _482 {
	
	//从后向前处理会更快，只需要一次遍历即可，剩下的即为开�?
	
	class Solution {
		public String licenseKeyFormatting(String S, int K) {
			
			char[] list = new char[S.length()];
			int len = 0;
			
			for (int i = 0; i < S.length(); ++i) {
				if (S.charAt(i) != '-') {
					list[len++] = (char) (S.charAt(i) <= 'Z' ? S.charAt(i)
							: S.charAt(i) - ('a' - 'A'));
				}
			}
			
			int leave = len % K;
			
			int ansLen = leave + (len / K) * (K + 1) + (leave == 0 ? -1 : 0);
			
			if (ansLen < 0)
				return "";
			
			char[] ans = new char[ansLen];
			
			for (int i = 0; i < leave; ++i) {
				ans[i] = list[i];
			}
			
			for (int i = leave, ansIndex = leave; i < len; ++i) {
				if ((i - leave) % K == 0) {
					if (i != leave || leave != 0) {
						ans[ansIndex++] = '-';
					}
				}
				ans[ansIndex++] = list[i];
			}
			
			return String.valueOf(ans);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println((int) 'a');
		System.out.println((int) 'A');
		System.out.println((int) '1');
	}
}
