package _0800_0899;

public class _883 {
	
	class Solution {
		public int projectionArea(int[][] grid) {
			int[]	maxO	= new int[grid.length];
			
			int		count	= 0;
			for (int i = 0; i < grid.length; ++i) {
				int max = 0;
				for (int j = 0; j < grid.length; ++j) {
					maxO[i]	= Math.max(maxO[j], grid[i][j]);
					max		= Math.max(max, grid[i][j]);
				}
				count += max;
			}
			
			for (int each : maxO) {
				count += each;
			}
			
			return count + grid.length * grid.length;
		}
	}
	
}
