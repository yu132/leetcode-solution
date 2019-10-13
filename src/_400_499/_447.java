package _400_499;

import java.util.HashMap;
import java.util.Map;

public class _447 {
	
	class Solution {
		
		public double dis(int x1, int y1, int x2, int y2) {
			return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		}
		
		public int numberOfBoomerangs(int[][] points) {
			
			int count = 0;
			
			for (int i = 0; i < points.length; ++i) {
				
				Map<Double, Integer> cache = new HashMap<>();
				
				for (int j = 0; j < points.length; ++j) {
					
					if (i == j) {
						continue;
					}
					
					double dis = dis(points[i][0], points[i][1], points[j][0], points[j][1]);
					
					cache.put(dis, cache.getOrDefault(dis, 0) + 1);
					
				}
				
				for (Integer n : cache.values()) {
					count += n * (n - 1);
				}
			}
			
			return count;
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(new _447().new Solution().numberOfBoomerangs(new int[][] {
				{
						0, 0
				}, {
						1, 0
				}, {
						2, 0
				}
		}));
		
		
	}
	
}
