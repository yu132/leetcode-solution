package _0900_0999;

public class _961 {
	
	class Solution {
		public int repeatedNTimes(int[] A) {
			if (A[0] == A[2]) {
				return A[0];
			} else if (A[1] == A[3]) {
				return A[1];
			} else if (A[0] == A[3]) {
				return A[1];
			}
			for (int i = 1; i < A.length; ++i) {
				if (A[i] == A[i - 1]) {
					return A[i];
				}
			}
			return -1;
		}
	}
	
}
