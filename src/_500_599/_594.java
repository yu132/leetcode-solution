package _500_599;

import java.util.HashMap;
import java.util.Map;

public class _594 {
	
	class Solution {
		public int findLHS(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>(nums.length);
			for (int each : nums) {
				map.put(each, map.getOrDefault(each, 0) + 1);
			}
			int max = 0;
			for (int each : map.keySet()) {
				if (map.containsKey(each + 1)) {
					max = Math.max(map.get(each) + map.get(each + 1), max);
				}
			}
			return max;
		}
	}
	
}
