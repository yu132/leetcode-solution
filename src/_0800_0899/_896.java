package _0800_0899;

public class _896 {
	
	class Solution {
		public boolean isMonotonic(int[] A) {
			
			if (A.length <= 2) {
				return true;
			}
			
			int temp = 0;
			
			for (int i = 1; i < A.length; ++i) {
				if (A[i] > A[i - 1]) {
					if (temp == -1) {
						return false;
					}
					temp = 1;
				} else if (A[i] < A[i - 1]) {
					if (temp == 1) {
						return false;
					}
					temp = -1;
				}
			}
			
			return true;
		}
	}
	
}
