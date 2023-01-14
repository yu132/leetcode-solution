package old._1000_1099;

import java.util.ArrayList;
import java.util.List;

public class _1042 {
	
	class Solution {
		public int[] gardenNoAdj(int N, int[][] paths) {
			
			@SuppressWarnings("unchecked")
			List<Integer>[] ways = new List[N + 1];
			
			for (int i = 1; i <= N; ++i) {
				ways[i] = new ArrayList<>(3);
			}
			
			for (int[] each : paths) {
				ways[each[0]].add(each[1]);
				ways[each[1]].add(each[0]);
			}
			
			int[] ans = new int[N];
			
			for (int i = 1; i <= N; ++i) {
				int c = 1;
				l: for (; c <= 4; ++c) {
					for (int each : ways[i]) {
						if (ans[each - 1] == c) {
							continue l;
						}
					}
					break;
				}
				ans[i - 1] = c;
			}
			
			return ans;
		}
	}
	
}
