package old._0700_0799;

import java.util.Arrays;

public class _748 {
	
	class Solution {
		
		public String shortestCompletingWord(String licensePlate, String[] words) {
			
			int[]	templete	= new int[26];
			int		countNo0	= 0;
			
			for (char each : licensePlate.toCharArray()) {
				if (each >= 'a' && each <= 'z') {
					++templete[each - 'a'];
					if (templete[each - 'a'] == 1) {
						++countNo0;
					}
				} else if (each >= 'A' && each <= 'Z') {
					++templete[each - 'A'];
					if (templete[each - 'A'] == 1) {
						++countNo0;
					}
				}
			}
			
			String	ans		= null;
			int		ansLen	= Integer.MAX_VALUE;
			
			for (String word : words) {
				int[]	temp		= Arrays.copyOf(templete, templete.length);
				int		tempCount	= countNo0;
				for (char each : word.toCharArray()) {
					if (each >= 'a' && each <= 'z') {
						--temp[each - 'a'];
						if (temp[each - 'a'] == 0) {
							--tempCount;
						}
					} else if (each >= 'A' && each <= 'Z') {
						--temp[each - 'A'];
						if (temp[each - 'A'] == 0) {
							--tempCount;
						}
					}
					if (tempCount == 0) {
						if (ansLen > word.length()) {
							ans		= word;
							ansLen	= word.length();
						}
						break;
					}
				}
			}
			
			return ans;
		}
	}
	
	
	public static void main(String[] args) {
		new _748().new Solution().shortestCompletingWord("1s3 PSt", new String[] {
				"looks", "pet", "stew", "show"
		});
	}
	
}
