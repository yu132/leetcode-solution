package old._0900_0999;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _970 {
	
	class Solution {
		public List<Integer> powerfulIntegers(int x, int y, int bound) {
			
			Set<Integer> set = new HashSet<>(Math.max(100, bound / 10));
			
			l: for (int i = 0;; ++i) {
				for (int j = 0;; ++j) {
					int num = (int) (Math.pow(x, i) + Math.pow(y, j));
					if (num <= bound) {
						set.add(num);
					} else {
						if (j == 0) {
							break l;
						} else {
							break;
						}
					}
					if (y == 1) {
						break;
					}
				}
				if (x == 1) {
					break;
				}
			}
			
			return new ArrayList<Integer>(set);
		}
	}
	
	public static void main(String[] args) {
		new _970().new Solution().powerfulIntegers(1, 2, 100);
	}
	
}
