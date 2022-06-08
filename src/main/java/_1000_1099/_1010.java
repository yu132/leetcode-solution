package _1000_1099;

public class _1010 {
	
	class Solution {
		public int numPairsDivisibleBy60(int[] time) {
			
			int[]	counter	= new int[60];
			
			int		count	= 0;
			for (int each : time) {
				count += counter[(60 - each % 60) % 60];
				++counter[each % 60];
			}
			
			return count;
		}
	}
	
}
