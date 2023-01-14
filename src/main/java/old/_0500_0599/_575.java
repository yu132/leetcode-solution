package old._0500_0599;

import java.util.HashSet;
import java.util.Set;

public class _575 {
	
	class Solution {
		public int distributeCandies(int[] candies) {
			
			Set<Integer> set = new HashSet<>(candies.length);
			
			for (int i : candies) {
				set.add(i);
			}
			
			return Math.min(candies.length / 2, set.size());
		}
	}
	
}
