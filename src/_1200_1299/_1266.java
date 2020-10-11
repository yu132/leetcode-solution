package _1200_1299;

public class _1266 {
	
	class Solution {
		public int minTimeToVisitAllPoints(int[][] points) {
			int distance = 0;
			for (int i = 1; i < points.length; ++i) {
				int	xDiff	= Math.abs(points[i - 1][0] - points[i][0]);
				int	yDiff	= Math.abs(points[i - 1][1] - points[i][1]);
				int	min		= Math.min(xDiff, yDiff);
				distance += xDiff + yDiff - min;
			}
			return distance;
		}
	}
	
	
	//	class Solution {
	//		public int minTimeToVisitAllPoints(int[][] points) {
	//			int distance = 0;
	//			for (int i = 1; i < points.length; ++i) {
	//				while (true) {
	//					int	xDiff	= points[i - 1][0] - points[i][0];
	//					int	yDiff	= points[i - 1][1] - points[i][1];
	//					if (xDiff != 0) {
	//						if (yDiff != 0) {
	//							points[i - 1][0]	+= xDiff < 0 ? 1 : -1;
	//							points[i - 1][1]	+= yDiff < 0 ? 1 : -1;
	//						} else {
	//							points[i - 1][0] += xDiff < 0 ? 1 : -1;
	//						}
	//					} else {
	//						if (yDiff != 0) {
	//							points[i - 1][1] += yDiff < 0 ? 1 : -1;
	//						} else {
	//							break;
	//						}
	//					}
	//					++distance;
	//				}
	//			}
	//			return distance;
	//		}
	//	}
	
}
