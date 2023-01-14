package old._1100_1199;

public class _1189 {
	
	class Solution {
		public int maxNumberOfBalloons(String text) {
			
			int[] count = new int[26];
			
			for (char each : text.toCharArray()) {
				++count[each - 'a'];
			}
			
			int min = Integer.MAX_VALUE;
			
			min	= Math.min(min, count['a' - 'a']);
			min	= Math.min(min, count['b' - 'a']);
			min	= Math.min(min, count['l' - 'a'] / 2);
			min	= Math.min(min, count['o' - 'a'] / 2);
			min	= Math.min(min, count['n' - 'a']);
			
			return min;
		}
	}
	
}
