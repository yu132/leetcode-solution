package _1100_1199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1122 {
	
	class Solution {
		public int[] relativeSortArray(int[] arr1, int[] arr2) {
			
			if (arr1.length <= 1) {
				return arr1;
			}
			
			Map<Integer, Integer> map = new HashMap<>();
			
			for (int i = 0; i < arr2.length; ++i) {
				map.put(arr2[i], i);
			}
			
			List<Integer> list = new ArrayList<>(arr1.length);
			
			for (int each : arr1) {
				list.add(each);
			}
			
			Collections.sort(list, (a, b) -> {
				int	ai	= map.getOrDefault(a, Integer.MAX_VALUE);
				int	bi	= map.getOrDefault(b, Integer.MAX_VALUE);
				if (ai == Integer.MAX_VALUE && bi == Integer.MAX_VALUE) {
					return Integer.compare(a, b);
				}
				return Integer.compare(ai, bi);
			});
			
			for (int i = 0; i < arr1.length; ++i) {
				arr1[i] = list.get(i);
			}
			
			return arr1;
		}
	}
	
}
