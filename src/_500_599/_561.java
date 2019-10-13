package _500_599;

import java.util.Arrays;

public class _561 {
	
	class Solution {
		public int arrayPairSum(int[] nums) {
			Arrays.sort(nums);
			int sum = 0;
			for (int i = 0; i < nums.length; i += 2) {
				sum += nums[i];
			}
			return sum;
		}
	}
	
}
