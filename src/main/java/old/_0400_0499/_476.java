package old._0400_0499;

public class _476 {
	
	class Solution {
		public int findComplement(int num) {
			int temp = num, c = 0;
			while (temp > 0) {
				temp >>= 1;
				c = (c << 1) + 1;
			}
			return num ^ c;
		}
	}
	
}
