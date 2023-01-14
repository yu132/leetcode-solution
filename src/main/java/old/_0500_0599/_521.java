package old._0500_0599;

public class _521 {
	
	class Solution {
		public int findLUSlength(String a, String b) {
			return a.length() != b.length() ? Math.max(a.length(), b.length())
					: a.equals(b) ? -1 : a.length();
		}
	}
	
}
