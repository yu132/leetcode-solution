package old._0500_0599;

public class _598 {
	
	class Solution {
		public int maxCount(int m, int n, int[][] ops) {
			
			int min1 = m, min2 = n;
			
			for (int[] each : ops) {
				min1 = Math.min(min1, each[0]);
				min2 = Math.min(min2, each[1]);
			}
			
			return min1 * min2;
		}
	}
	
}
