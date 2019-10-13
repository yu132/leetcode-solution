package _900_999;

import java.util.Arrays;

public class _949 {
	
	class Solution {
		
		public String helper(int[] A, int index, int limit) {
			int	i	= A.length - index - 1;
			int	ix	= i;
			while (ix >= 0) {
				if (A[ix] <= limit) {
					int temp = A[i];
					A[i]	= A[ix];
					A[ix]	= temp;
					
					int[] copy = Arrays.copyOf(A, 4);
					
					Arrays.sort(copy, 0, i);
					
					String s = "";
					if (index == 0) {
						if (A[i] < 2) {
							s = helper(copy, index + 1, 9);
						} else {
							s = helper(copy, index + 1, 3);
						}
					} else if (index == 1) {
						s = helper(copy, index + 1, 5);
					} else if (index == 2) {
						s = helper(copy, index + 1, 9);
					} else {
						return "" + A[3] + A[2] + ":" + A[1] + A[0];
					}
					if (!s.equals("")) {
						return s;
					}
					
					A[ix]	= A[i];
					A[i]	= temp;
				}
				--ix;
			}
			
			return "";
		}
		
		
		public String largestTimeFromDigits(int[] A) {
			Arrays.sort(A);
			return helper(A, 0, 2);
		}
	}
	
	public static void main(String[] args) {
		new _949().new Solution().largestTimeFromDigits(new int[] { 0, 4, 0, 3 });
	}
	
}
