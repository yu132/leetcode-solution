package _0700_0799;

public class _746 {
	
	class Solution {
		public int minCostClimbingStairs(int[] cost) {
			int m0 = cost[0], m1 = cost[1], m2, index = 2;
			
			while (index != cost.length) {
				
				m2	= Math.min(m0, m1) + cost[index];
				
				m0	= m1;
				m1	= m2;
				
				++index;
			}
			
			return Math.min(m0, m1);
		}
	}
	
}
