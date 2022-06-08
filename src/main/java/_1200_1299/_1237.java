package _1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1237 {
	
	interface CustomFunction {
		// Returns f(x, y) for any given positive integers x and y.
		// Note that f(x, y) is increasing with respect to both x and y.
		// i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
		public int f(int x, int y);
	};
	
	class Solution {
		public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
			
			List<List<Integer>>	ans		= new ArrayList<List<Integer>>();
			
			int					start	= 1, end = 1000;
			while (start <= 1000 && end >= 1) {
				int now = customfunction.f(start, end);
				if (now == z) {
					ans.add(Arrays.asList(new Integer[] { start, end }));
					++start;
					--end;
				} else if (now > z) {
					--end;
				} else {
					++start;
				}
			}
			
			return ans;
		}
	}
	
}
