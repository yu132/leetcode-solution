package _400_499;

public class _485 {
	
	class Solution {
		public int findMaxConsecutiveOnes(int[] nums) {
			
			int con1 = 0, maxLen = 0;
			
			for (int i = 0; i < nums.length; ++i) {
				if (nums[i] == 1) {
					++con1;
				} else {
					maxLen = Math.max(con1, maxLen);
					con1 = 0;
				}
			}
			
			maxLen = Math.max(con1, maxLen);
			
			return maxLen;
		}
	}
	
}
