package old._0800_0899;

public class _812 {
	
	class Solution {
		
		private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
			return Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2) / 2.0;
		}
		
		public double largestTriangleArea(int[][] points) {
			double max = -1;
			for (int i = 0; i < points.length; ++i) {
				for (int j = i + 1; j < points.length; ++j) {
					for (int k = j + 1; k < points.length; ++k) {
						max = Math.max(max, area(points[i][0], points[i][1], points[j][0],
								points[j][1], points[k][0], points[k][1]));
					}
				}
			}
			return max;
		}
	}
	
}
