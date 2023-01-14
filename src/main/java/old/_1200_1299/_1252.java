package old._1200_1299;

public class _1252 {
	
	class Solution {
		public int oddCells(int n, int m, int[][] indices) {
			int[] row = new int[n], col = new int[m];
			for (int[] each : indices) {
				++row[each[0]];
				++col[each[1]];
			}
			int oddr = 0, oddc = 0;
			for (int each : row) {
				if (each % 2 == 1) {
					++oddr;
				}
			}
			for (int each : col) {
				if (each % 2 == 1) {
					++oddc;
				}
			}
			return oddr * m + oddc * n - oddr * oddc * 2;
		}
	}
	
}
