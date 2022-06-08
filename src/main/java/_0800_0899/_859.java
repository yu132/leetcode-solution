package _0800_0899;

public class _859 {
	
	class Solution {
		public boolean buddyStrings(String A, String B) {
			
			if (A.length() != B.length()) {
				return false;
			}
			
			char	defA1	= 0;
			char	defA2	= 0;
			char	defB1	= 0;
			char	defB2	= 0;
			
			int		count	= 0;
			
			for (int i = 0; i < A.length(); ++i) {
				if (A.charAt(i) != B.charAt(i)) {
					++count;
					if (count == 1) {
						defA1	= A.charAt(i);
						defB1	= B.charAt(i);
					} else if (count == 2) {
						defA2	= A.charAt(i);
						defB2	= B.charAt(i);
						if (defA1 != defB2 || defA2 != defB1) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
			
			if (count == 0) {
				int[] c = new int[26];
				
				for (char each : A.toCharArray()) {
					++c[each - 'a'];
					if (c[each - 'a'] == 2) {
						return true;
					}
				}
				
				return false;
			} else if (count == 1) {
				return false;
			}
			
			return true;//count==2
		}
	}
	
}
