package _0500_0599;

import java.util.Arrays;

public class _506 {
	
	class Solution {
		
		public String[] findRelativeRanks(int[] nums) {
			int[][] cache = new int[nums.length][2];
			for (int i = 0; i < nums.length; ++i) {
				cache[i][0] = nums[i];
				cache[i][1] = i;
			}
			Arrays.sort(cache, (a, b) -> {
				return Integer.compare(b[0], a[0]);
			});
			
			String[] ans = new String[nums.length];
			
			for (int i = 0; i < cache.length; ++i) {
				switch (i + 1) {
					case 1:
						ans[cache[i][1]] = "Gold Medal";
						break;
					case 2:
						ans[cache[i][1]] = "Silver Medal";
						break;
					case 3:
						ans[cache[i][1]] = "Bronze Medal";
						break;
					default:
						ans[cache[i][1]] = String.valueOf(i + 1);
						break;
				}
			}
			
			return ans;
		}
	}
	
	public static void main(String[] args) {
		new _506().new Solution().findRelativeRanks(new int[] {
				5, 4, 3, 2, 1
		});
	}
	
}
