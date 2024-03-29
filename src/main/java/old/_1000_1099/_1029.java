package old._1000_1099;

import java.util.Arrays;

public class _1029 {
	
	class Solution {
		public int twoCitySchedCost(int[][] costs) {
			
			Arrays.sort(costs, (a, b) -> {
				return Integer.compare(a[0] - a[1], b[0] - b[1]);
			});
			
			int	mid	= costs.length / 2;
			
			int	sum	= 0;
			for (int i = 0; i < mid; ++i) {
				sum += costs[i][0];
			}
			for (int i = mid; i < costs.length; ++i) {
				sum += costs[i][1];
			}
			
			return sum;
		}
	}
	
}
