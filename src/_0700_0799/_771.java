package _0700_0799;

public class _771 {
	
	class Solution {
		
		private int hash(char c) {
			if (c >= 'a' && c <= 'z') {
				return c - 'a';
			} else if (c >= 'A' && c <= 'Z') {
				return c - 'A' + 26;
			}
			return -1;
		}
		
		public int numJewelsInStones(String J, String S) {
			boolean[] flag = new boolean[26 * 2];
			
			for (char each : J.toCharArray()) {
				flag[hash(each)] = true;
			}
			
			int count = 0;
			
			for (char each : S.toCharArray()) {
				if (flag[hash(each)]) {
					++count;
				}
			}
			
			return count;
		}
	}
	
}
