package old._0400_0499;

public class _441 {
	
	/**  数学公式�?
	 * 	class Solution {
			public int arrangeCoins(int n) {
	    		return (int)(Math.sqrt(2 * (double)n + 0.25) - 0.5);
			}
		}
	 * */
	
	class Solution {
		
		public int sumN(int i) {
			if (i % 2 == 0) {
				return i / 2 * (i + 1);
			} else {
				return (i + 1) / 2 * i;
			}
		}
		
		public int arrangeCoins(int n) {
			
			int low = 1, high = 65535;
			
			while (low <= high) {
				int mid = (low + high) >>> 1;
				
				if (sumN(mid) == n) {
					return mid;
				} else if (sumN(mid) > n) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			
			return low - 1;
		}
	}
	
	public static int sumN(int i) {
		if (i % 2 == 0) {
			return i / 2 * (i + 1);
		} else {
			return (i + 1) / 2 * i;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new _441().new Solution().arrangeCoins(9));
		
		//System.out.println(sumN(65535));
	}
}
