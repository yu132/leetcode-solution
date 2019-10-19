package _0900_0999;

public class _922 {
	
	class Solution {
		
		public int[] sortArrayByParityII(int[] A) {
			
			int low = 0, high = (A.length - 1) % 2 == 0 ? A.length - 2 : A.length - 1;
			
			while (true) {
				while (low < A.length && A[low] % 2 == 0) {
					low += 2;
				}
				while (high >= 0 && A[high] % 2 == 1) {
					high -= 2;
				}
				if (low >= A.length) {
					break;
				}
				int temp = A[low];
				A[low]	= A[high];
				A[high]	= temp;
				low		+= 2;
				high	-= 2;
			}
			
			return A;
		}
	}
	
	public static void main(String[] args) {
		new _922().new Solution().sortArrayByParityII(new int[] { 2, 3, 1, 1, 4, 0, 0, 4, 3, 3 });
	}
	
}
