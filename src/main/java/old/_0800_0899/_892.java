package old._0800_0899;

public class _892 {
	
	class Solution {
		public int surfaceArea(int[][] grid) {
			
			int count = 0;
			
			for (int i = 0; i < grid.length; ++i) {
				for (int j = 0; j < grid.length; ++j) {
					if (grid[i][j] != 0) {
						count += grid[i][j] * 4 + 2;
					}
					if (i > 0) {
						count -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
					}
					if (j > 0) {
						count -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
					}
				}
			}
			
			return count;
		}
	}
	
}
