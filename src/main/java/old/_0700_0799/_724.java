package old._0700_0799;

public class _724 {
	
	class Solution {
		public int pivotIndex(int[] nums) {
			int sumL = 0, sumR = 0;
			
			for (int i = 1; i < nums.length; ++i) {
				sumR += nums[i];
			}
			
			for (int i = 0; i < nums.length - 1; ++i) {
				if (sumL == sumR) {
					return i;
				} else {
					sumL	+= nums[i];
					sumR	-= nums[i + 1];
				}
			}
			
			if (sumL == sumR) {
				return nums.length - 1;
			}
			
			return -1;
		}
	}
	
}
