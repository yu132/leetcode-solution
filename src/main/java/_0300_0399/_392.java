package _0300_0399;

public class _392 {
	
	class Solution {
		public boolean isSubsequence(String s, String t) {
			
			if (s.length() == 0) {
				return true;
			}
			
			int sI = 0, tI = 0;
			
			while (tI < t.length()) {
				
				if (s.charAt(sI) == t.charAt(tI)) {
					++sI;
					if (sI == s.length()) {
						return true;
					}
				}
				
				++tI;
			}
			
			return false;
			
		}
	}
	
}
