package old._0900_0999;

import java.util.HashMap;
import java.util.Map;

public class _953 {
	
	class Solution {
		
		private int compareTo(String x, String y, Map<Character, Integer> orderMap) {
			int index = 0;
			
			while (index != x.length()) {
				
				int	xo	= orderMap.get(x.charAt(index));
				int	yo	= orderMap.get(y.charAt(index));
				
				if (xo == yo) {
					++index;
					continue;
				} else if (xo < yo) {
					return -1;
				} else {// xo > yo
					return 1;
				}
			}
			
			if (index == x.length()) {
				if (index == y.length()) {
					return 0;
				} else {
					return -1;
				}
			}
			return 1;
		}
		
		public boolean isAlienSorted(String[] words, String order) {
			
			Map<Character, Integer>	orderMap	= new HashMap<>();
			
			char[]					temp		= order.toCharArray();
			
			for (int i = 0; i < temp.length; ++i) {
				orderMap.put(temp[i], i);
			}
			
			for (int i = 1; i < words.length; ++i) {
				if (compareTo(words[i], words[i - 1], orderMap) < 0) {
					return false;
				}
			}
			
			return true;
		}
	}
	
}
