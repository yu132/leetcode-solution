package old._0700_0799;

import java.util.ArrayList;
import java.util.List;

public class _728 {
	
	class Solution {
		public List<Integer> selfDividingNumbers(int left, int right) {
			
			List<Integer> ans = new ArrayList<>();
			
			l: for (int i = left; i <= right; ++i) {
				int num = i;
				while (num != 0) {
					if (num % 10 != 0 && i % (num % 10) == 0) {
						num /= 10;
					} else {
						continue l;
					}
				}
				ans.add(i);
			}
			
			return ans;
		}
	}
	
}
