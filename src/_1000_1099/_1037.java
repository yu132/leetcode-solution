package _1000_1099;

public class _1037 {
	
	class Solution {
		
		private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
			return Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2) / 2.0;
		}
		
		public boolean isBoomerang(int[][] points) {
			
			return area(points[0][0], points[0][1], points[1][0], points[1][1], points[2][0],
					points[2][1]) != 0;
			
		}
	}
	
}
