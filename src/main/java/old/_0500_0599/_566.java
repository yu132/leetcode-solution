package old._0500_0599;

public class _566 {
	
	class Solution {
		public int[][] matrixReshape(int[][] nums, int r, int c) {
			
			if (nums.length == 0) {
				return nums;
			}
			
			int x = nums.length, y = nums[0].length;
			
			if (x * y != r * c) {
				return nums;
			}
			
			int[][] reshape = new int[r][c];
			int rIndex = 0;
			int cIndex = 0;
			
			for (int i = 0; i < nums.length; ++i) {
				for (int j = 0; j < nums[0].length; ++j) {
					reshape[rIndex][cIndex++] = nums[i][j];
					if (cIndex == c) {
						cIndex = 0;
						++rIndex;
					}
				}
			}
			
			return reshape;
		}
	}
	
}
