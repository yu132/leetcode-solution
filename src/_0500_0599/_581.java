package _0500_0599;

public class _581 {
	
	class Solution {
		public int findUnsortedSubarray(int[] nums) {
			
			int low = 1, high = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			
			for (int i = 0; i < nums.length; ++i) {
				if (nums[i] < max) {
					high = i;
				} else {
					max = nums[i];
				}
			}
			
			for (int i = nums.length - 1; i >= 0; --i) {
				if (nums[i] > min) {
					low = i;
				} else {
					min = nums[i];
				}
			}
			
			return low == high ? 0 : high - low + 1;
		}
	}
	
}
