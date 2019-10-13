package _900_999;

public class _908 {

	class Solution {
		public int smallestRangeI(int[] A, int K) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < A.length; ++i) {
				max = Math.max(A[i], max);
				min = Math.min(A[i], min);
			}

			return Math.max(0, max - min - 2 * K);
		}
	}

}
