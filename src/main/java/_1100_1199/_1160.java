package _1100_1199;

public class _1160 {
	
	class Solution {
		public int countCharacters(String[] words, String chars) {
			int[] countc = new int[26];
			
			for (char each : chars.toCharArray()) {
				++countc[each - 'a'];
			}
			
			int count = 0;
			l: for (String each : words) {
				int[] countc2 = new int[26];
				for (char eachc : each.toCharArray()) {
					++countc2[eachc - 'a'];
				}
				
				for (int i = 0; i < 26; ++i) {
					if (countc2[i] > countc[i]) {
						continue l;
					}
				}
				
				count += each.length();
			}
			
			return count;
		}
	}
	
}
