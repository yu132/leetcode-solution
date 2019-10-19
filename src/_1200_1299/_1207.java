package _1200_1299;

public class _1207 {
	
	class Solution {
		public boolean uniqueOccurrences(int[] arr) {
			
			int[]		counter	= new int[2001];
			
			boolean[]	occupy	= new boolean[1001];
			
			for (int each : arr) {
				++counter[each + 1000];
			}
			
			for (int each : counter) {
				if (each == 0) {
					continue;
				}
				if (occupy[each]) {
					return false;
				} else {
					occupy[each] = true;
				}
			}
			
			return true;
		}
	}
	
}
