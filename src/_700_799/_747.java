package _700_799;

public class _747 {
	
	class Solution {
		public int dominantIndex(int[] nums) {
			if (nums.length == 1) {
				return 0;
			}
			
			int m0, m1, index;
			if (nums[0] >= nums[1]) {
				m0		= nums[0];
				m1		= nums[1];
				index	= 0;
			} else {
				m0		= nums[1];
				m1		= nums[0];
				index	= 1;
			}
			
			for (int i = 2; i < nums.length; ++i) {
				if (nums[i] >= m0) {
					m1		= m0;
					m0		= nums[i];
					index	= i;
				} else if (nums[i] > m1) {
					m1 = nums[i];
				}
			}
			
			return m0 >= m1 * 2 ? index : -1;
		}
	}
	
}
