package old._0900_0999;

import java.util.Arrays;

public class _944 {
	
	class Solution {
		public int minDeletionSize(String[] A) {
			
			if (A.length == 0) {
				return 0;
			}
			
			boolean[] flag = new boolean[A[0].length()];
			
			Arrays.fill(flag, true);
			
			for (int i = 1; i < A.length; ++i) {
				for (int j = 0; j < A[i].length(); ++j) {
					if (A[i].charAt(j) < A[i - 1].charAt(j)) {
						flag[j] = false;
					}
				}
			}
			
			int count = 0;
			for (boolean each : flag) {
				if (!each) {
					++count;
				}
			}
			
			return count;
		}
	}
	
}
