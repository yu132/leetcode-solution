package old._0400_0499;

import java.util.Arrays;

public class _473 {
	
	class Solution {
		public boolean makesquare(int[] nums) {
			if (nums.length < 4)
				return false;
			int sum = 0;
			for (int each : nums) {
				sum += each;
			}
			if (sum % 4 != 0) {
				return false;
			}
			for (int each : nums) {
				if (each > sum / 4) {
					return false;
				}
			}
			Arrays.sort(nums);
			return helper(nums, nums.length - 1, 0, 0, 0, 0, sum / 4);
		}
		
		public boolean helper(int[] nums, int index, int s1, int s2, int s3, int s4, int max) {
			if (index == -1) {
				return s1 == s2 && s1 == s3 && s1 == s4;
			}
			
			if (s1 > max || s2 > max || s3 > max || s4 > max) {
				return false;
			}
			
			return helper(nums, index - 1, s1 + nums[index], s2, s3, s4, max) ||
					helper(nums, index - 1, s1, s2 + nums[index], s3, s4, max) ||
					helper(nums, index - 1, s1, s2, s3 + nums[index], s4, max) ||
					helper(nums, index - 1, s1, s2, s3, s4 + nums[index], max);
		}
	}
	
}
