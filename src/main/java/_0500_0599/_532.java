package _0500_0599;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _532 {
	
	class Solution {
		public int findPairs(int[] nums, int k) {
			
			if (k < 0)
				return 0;
			
			int count = 0;
			
			if (k == 0) {
				Map<Integer, Integer> map = new HashMap<>();
				
				for (int i = 0; i < nums.length; ++i) {
					int time = map.getOrDefault(nums[i], 0) + 1;
					if (time == 2) {
						++count;
					}
					map.put(nums[i], time);
				}
				
				return count;
			}
			
			Set<Integer> set = new HashSet<>(nums.length);
			
			for (int i = 0; i < nums.length; ++i) {
				set.add(nums[i]);
			}
			
			for (int each : set) {
				if (set.contains(each + k)) {
					++count;
				}
			}
			
			return count;
		}
	}
	
}
