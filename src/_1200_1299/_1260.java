package _1200_1299;

import java.util.ArrayList;
import java.util.List;

public class _1260 {
	class Solution {
		public List<List<Integer>> shiftGrid(int[][] grid, int k) {
			
			int		n		= grid.length, m = grid[0].length;
			
			int[]	array	= new int[n * m];
			
			for (int i = 0; i < grid.length; ++i) {
				int index = i * m + k;
				index %= n * m;
				if (index + m < n * m) {
					System.arraycopy(grid[i], 0, array, index, m);
				} else {
					System.arraycopy(grid[i], 0, array, index, n * m - index);
					System.arraycopy(grid[i], n * m - index, array, 0, m - (n * m - index));
				}
			}
			
			List<List<Integer>> ans = new ArrayList<>();
			
			for (int i = 0; i < n; ++i) {
				List<Integer> list = new ArrayList<>();
				for (int j = 0; j < m; ++j) {
					list.add(array[i * m + j]);
				}
				ans.add(list);
			}
			
			return ans;
		}
	}
}
