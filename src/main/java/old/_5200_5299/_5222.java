package old._5200_5299;

public class _5222 {
	
	class Solution {
		public int balancedStringSplit(String s) {
			int c = 0, count = 0;
			for (char each : s.toCharArray()) {
				if (each == 'R') {
					++c;
					if (c == 0) {
						++count;
					}
				} else if (each == 'L') {
					--c;
					if (c == 0) {
						++count;
					}
				}
			}
			return count;
		}
	}
	
}
