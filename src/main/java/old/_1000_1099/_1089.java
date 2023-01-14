package old._1000_1099;

public class _1089 {
	
	class Solution {
		public void duplicateZeros(int[] arr) {
			int fast = 0, slow = 0;
			
			while (true) {
				if (arr[slow] == 0) {
					fast += 2;
					if (fast > arr.length) {
						arr[arr.length - 1]	= 0;
						fast				= arr.length - 2;
						--slow;
						break;
					} else if (fast == arr.length) {
						--fast;
						break;
					}
					slow += 1;
				} else {// == 1
					fast += 1;
					if (fast == arr.length) {
						--fast;
						break;
					}
					slow += 1;
				}
			}
			
			for (; slow >= 0; --slow) {
				if (arr[slow] == 0) {
					arr[fast]		= 0;
					arr[fast - 1]	= 0;
					fast			-= 2;
				} else {
					arr[fast]	= arr[slow];
					fast		-= 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new _1089().new Solution().duplicateZeros(new int[] { 1, 0 });
	}
}
