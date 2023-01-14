package old._0600_0699;

public class _665 {
	
	class Solution {
		public boolean checkPossibility(int[] nums) {
			
			int countNG = 0;
			
			for (int i = 1; i < nums.length; ++i) {
				if (nums[i - 1] <= nums[i]) {
					continue;
				}
				++countNG;
				if (countNG > 1) {
					return false;
				}
				if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
					nums[i] = nums[i - 1];
				} else {
					nums[i - 1] = nums[i];
				}
			}
			
			return true;
		}
	}
	
}
