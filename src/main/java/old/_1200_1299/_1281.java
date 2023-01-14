package old._1200_1299;

public class _1281 {
	
	class Solution {
		public int subtractProductAndSum(int n) {
			int sum = 0, product = 1;
			while (n != 0) {
				sum		+= n % 10;
				product	*= n % 10;
				n		/= 10;
			}
			return product - sum;
		}
	}
	
}
