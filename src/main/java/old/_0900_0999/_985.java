package old._0900_0999;

public class _985 {
	
	class Solution {
		public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
			
			int sumEven = 0;
			for (int each : A) {
				if (each % 2 == 0) {
					sumEven += each;
				}
			}
			
			int[] ans = new int[queries.length];
			
			for (int i = 0; i < queries.length; ++i) {
				int	val		= queries[i][0];
				int	index	= queries[i][1];
				
				if (A[index] % 2 == 0) {
					A[index] += val;
					if (A[index] % 2 == 0) {
						sumEven += val;
					} else {
						sumEven -= A[index] - val;
					}
				} else {
					A[index] += val;
					if (A[index] % 2 == 0) {
						sumEven += A[index];
					}
				}
				ans[i] = sumEven;
			}
			
			return ans;
		}
	}
	
}
