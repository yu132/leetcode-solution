package lcp;

public class LCP02 {
	
	class Solution {
		
		public int gcd(int m, int n) {
			int r;
			while (n > 0) {
				r	= m % n;
				m	= n;
				n	= r;
			}
			return m;
		}
		
		public int[] fraction(int[] cont) {
			
			if (cont.length == 1) {
				return new int[] { cont[0], 1 };
			}
			
			int	numerator	= 1;//����
			int	denominator	= cont[cont.length - 1];//��ĸ
			
			for (int i = cont.length - 2; i >= 1; --i) {//���һ����Ӳ��������ӷ�ĸ
				int temp = numerator + cont[i] * denominator;
				numerator	= denominator;
				denominator	= temp;
			}
			
			numerator = numerator + cont[0] * denominator;
			
			int gcd = gcd(numerator, denominator);
			
			return new int[] { numerator / gcd, denominator / gcd };
		}
	}
	
}
