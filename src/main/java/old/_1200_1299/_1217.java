package old._1200_1299;

public class _1217 {
	
	class Solution {
		public int minCostToMoveChips(int[] chips) {
			
			int codd = 0, ceven = 0;
			
			for (int each : chips) {
				if (each % 2 == 0) {
					++ceven;
				} else {
					++codd;
				}
			}
			
			return Math.min(codd, ceven);
		}
	}
	
}
