package _0900_0999;

import java.util.HashSet;
import java.util.Set;

public class _939 {
	
	class Solution {
		public int minAreaRect(int[][] points) {
			
			Set<Integer> set = new HashSet<>();
			
			for (int[] each : points) {
				set.add(40001 * each[0] + each[1]);
			}
			
			int ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < points.length; ++i) {
				for (int j = i + 1; j < points.length; ++j) {
					if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
						if (set.contains(points[i][0] * 40001 + points[j][1])
								&& set.contains(points[j][0] * 40001 + points[i][1])) {
							ans = Math.min(ans, Math.abs((points[j][0] - points[i][0])
									* (points[j][1] - points[i][1])));
						}
					}
				}
			}
			
			return ans < Integer.MAX_VALUE ? ans : 0;
		}
	}
	
}
