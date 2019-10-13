package _1000_1099;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1030 {
	
	class Solution {
		
		final int[][]		dir		= { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		
		public Deque<int[]>	queue	= new ArrayDeque<>();
		
		public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
			boolean[][]	visited	= new boolean[R][C];
			int[][]		ans		= new int[R * C][2];
			int			index	= 0;
			queue.add(new int[] { r0, c0 });
			while (!queue.isEmpty()) {
				int[]	temp	= queue.removeFirst();
				int		r		= temp[0];
				int		c		= temp[1];
				if (r < 0 || c < 0 || r == R || c == C) {
					continue;
				}
				if (visited[r][c]) {
					continue;
				}
				visited[r][c]	= true;
				ans[index][0]	= r;
				ans[index][1]	= c;
				++index;
				for (int[] each : dir) {
					queue.addLast(new int[] { r + each[0], c + each[1] });
				}
			}
			return ans;
		}
	}
	
}
