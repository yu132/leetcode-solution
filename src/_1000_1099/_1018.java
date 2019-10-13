package _1000_1099;

import java.util.ArrayList;
import java.util.List;

public class _1018 {
	
	class Solution {
		public List<Boolean> prefixesDivBy5(int[] A) {
			
			List<Boolean>	list	= new ArrayList<>();
			
			int				a		= 0;
			for (int each : A) {
				a	<<= 1;
				a	+= each;
				a	%= 10;
				list.add(a % 5 == 0);
			}
			
			return list;
		}
	}
	
	
}
