package _0900_0999;

public class _905 {
	
	class Solution {
		public int[] sortArrayByParity(int[] A) {
			
			int low = 0, high = A.length - 1;
			
			while (low <= high) {
				while (low <= high && A[low] % 2 == 0) {
					++low;
				}
				while (low <= high && A[high] % 2 == 1) {
					--high;
				}
				if (low < high) {
					int temp = A[low];
					A[low]	= A[high];
					A[high]	= temp;
				}
			}
			
			return A;
		}
	}
	
	public static void main(String[] args) {
		new _905().new Solution().sortArrayByParity(new int[] { 4, 1, 2, 3 });
	}
	
}
