package old._0400_0499;

import java.util.Arrays;

public class _475 {
	
	class Solution {
		public int minDiff(int[] array, int target) {
			int f = 0, b = array.length - 1;
			while (f <= b) {
				int mid = (f + b) >>> 1;
				
				if (array[mid] < target)
					f = mid + 1;
				else if (array[mid] > target)
					b = mid - 1;
				else
					return 0;
			}
			if (b >= 0) {
				int min = target - array[b];
				if (f < array.length) {
					int temp = array[f] - target;
					if (min > temp) {
						min = temp;
					}
				}
				return min;
			}
			return array[f] - target;
		}
		
		public int findRadius(int[] houses, int[] heaters) {
			
			Arrays.sort(heaters);
			
			int max = 0;
			
			for (int i = 0; i < houses.length; ++i) {
				int minDiff = minDiff(heaters, houses[i]);
				max = Math.max(minDiff, max);
			}
			
			return max;
		}
	}
	
}
