package old._0800_0899;

public class _852 {
	
	class Solution {
		public int peakIndexInMountainArray(int[] A) {
			int low = 0, high = A.length - 1;
			
			while (low <= high) {
				int mid = (low + high) >>> 1;
				if (A[mid + 1] > A[mid]) {
					low = mid;
				} else if (A[mid - 1] > A[mid]) {
					high = mid;
				} else {
					return mid;
				}
			}
			
			return -1;
		}
	}
	
}
