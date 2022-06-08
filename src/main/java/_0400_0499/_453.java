package _0400_0499;

public class _453 {
	
	class Solution {
		public int minMoves(int[] nums) {
			
			if (nums.length == 0)
				return 0;
			
			int min = nums[0];
			
			int countMinus = 0;
			
			for (int i = 1; i < nums.length; ++i) {
				if (nums[i] >= min) {
					countMinus += nums[i] - min;
				} else {
					int dif = min - nums[i];
					countMinus += dif * i;
					min = nums[i];
				}
			}
			
			return countMinus;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(new _453().new Solution().minMoves(new int[] {
				1, 2, 3, 4
		}));
	}
}
