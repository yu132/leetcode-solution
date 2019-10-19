package _0500_0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599 {
	
	class Solution {
		public String[] findRestaurant(String[] list1, String[] list2) {
			
			String[] shortOne = (list1.length <= list2.length ? list1 : list2);
			String[] longOne = (shortOne == list1 ? list2 : list1);
			
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < longOne.length; ++i) {
				map.put(longOne[i], i);
			}
			
			int min = Integer.MAX_VALUE;
			List<String> array = new ArrayList<>();
			
			for (int i = 0; i < shortOne.length; ++i) {
				if (map.containsKey(shortOne[i])) {
					int index = i + map.get(shortOne[i]);
					if (index < min) {
						min = index;
						array.clear();
						array.add(shortOne[i]);
					} else if (index == min) {
						array.add(shortOne[i]);
					}
				}
			}
			
			return array.toArray(new String[array.size()]);
		}
	}
	
}
