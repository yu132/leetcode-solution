package old._0200_0299;

public class _287 {
	
	class Solution {
		public int findDuplicate(int[] nums) {
			int fast = 0, slow = 0;
			
			while (true) {
				fast	= nums[nums[fast]];
				slow	= nums[slow];
				if (slow == fast) {
					fast = 0;
					while (nums[slow] != nums[fast]) {
						fast	= nums[fast];
						slow	= nums[slow];
					}
					return nums[slow];
				}
			}
		}
	}
	
}
