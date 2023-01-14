package old._0700_0799;

public class _788 {
	
	class Solution {
		
		private boolean isGood(int n) {
			
			int count = 0;
			
			while (n != 0) {
				int digit = n % 10;
				
				if (digit == 3 || digit == 4 || digit == 7) {
					return false;
				}
				
				if (digit != 0 && digit != 1 && digit != 8) {
					++count;
				}
				
				n /= 10;
			}
			
			return count > 0;
		}
		
		public int rotatedDigits(int N) {
			
			int count = 0;
			for (int i = 1; i <= N; ++i) {
				if (isGood(i)) {
					++count;
				}
			}
			
			return count;
			
		}
	}
	
}
