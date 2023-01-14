package old._1200_1299;

public class _1232 {
	
	class Solution {
		public boolean checkStraightLine(int[][] coordinates) {
			double gradient = (coordinates[0][1] - coordinates[1][1]) * 1.0
					/ (coordinates[0][0] - coordinates[1][0]);
			for (int i = 2; i < coordinates.length; ++i) {
				double now = (coordinates[0][1] - coordinates[i][1]) * 1.0
						/ (coordinates[0][0] - coordinates[i][0]);
				if (gradient != now) {
					return false;
				}
			}
			return true;
		}
	}
	
}
